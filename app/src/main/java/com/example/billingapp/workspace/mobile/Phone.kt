package com.example.billingapp.workspace.mobile

import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.PressGestureScope
import androidx.compose.foundation.gestures.detectDragGesturesAfterLongPress
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.billingapp.workspace.data.InventoryPhone
import com.google.firebase.database.*
import java.time.temporal.TemporalQueries.offset
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay

class InventoryViewModel(name: String) : ViewModel() {
    constructor() : this("")
    private val database = FirebaseDatabase.getInstance().reference.child("Inventory/Inventory/Phones/$name")
    private val _inventoryItems = mutableStateOf(emptyList<InventoryPhone>())
    val inventoryItems: List<InventoryPhone> get() = _inventoryItems.value
    var loading by mutableStateOf(true)

    init {
        loadData()
    }

    private fun loadData() {
        val inventoryListener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val items = mutableListOf<InventoryPhone>()

                for (productSnapshot in snapshot.children) {
                    val name = productSnapshot.key.toString()
                    val units = productSnapshot.child("units").getValue<Long?>() ?: 0
                    val specsSnapshot = productSnapshot.child("specs")
                    val specs = if (specsSnapshot.exists()) {
                        mapOf(
                            "color" to specsSnapshot.child("color").value.toString(),
                            "storage" to specsSnapshot.child("storage").value.toString()
                        )
                    } else {
                        null
                    }

                    items.add(InventoryPhone(name, units.toInt(), specs))
                }
                loading = false
                _inventoryItems.value = items


            }

            override fun onCancelled(error: DatabaseError) {
                // Handle error
                loading = false
            }
        }

        database.addValueEventListener(inventoryListener)
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneInventory(phoneName: String, controller:NavController) {
    val inventoryViewModel: InventoryViewModel = viewModel(factory = ViewModelFactory(phoneName))

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Phone Inventory")
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xffff6b00)
                ),
                navigationIcon = {
                    IconButton(onClick = { controller.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            if (inventoryViewModel.loading) {
                CircularProgressIndicator(
                    modifier = Modifier.size(50.dp),
                )
            } else if (inventoryViewModel.inventoryItems.isEmpty()) {
                // Empty state
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text("No items available.")
                }
            } else {
                // Display the list
                LazyColumn {
                    items(inventoryViewModel.inventoryItems) { item ->
                        InventoryItemRow(item,phoneName, controller =controller)
                        HorizontalDivider(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(Color.Gray),
                            thickness = 3.dp
                        )
                        Spacer(modifier = Modifier.height(2.dp))
                    }
                }
            }
        }
    }
}

class ViewModelFactory(private val phoneName: String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InventoryViewModel::class.java)) {
            return InventoryViewModel(phoneName) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun InventoryItemRow(item: InventoryPhone,phoneName:String,controller: NavController) {
    var isContextMenuVisible by remember { mutableStateOf(false) }
    var pressOffset by remember {
        mutableStateOf(DpOffset.Zero)
    }
    val interactionSource = remember {
        MutableInteractionSource()
    }

    Card(
        colors = CardColors(
            containerColor = Color(0xFFFFBBA6),
            contentColor = Color(0xFF2E2E2E),
            disabledContainerColor = Color(0xFF6BBCC7),
            disabledContentColor = Color(0xFF6BBCC7)
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 5.dp,
            pressedElevation = 12.dp,
            focusedElevation = 10.dp,
            hoveredElevation = 10.dp,
            draggedElevation = 10.dp,
            disabledElevation = 4.dp
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(7.5.dp)
            .indication(interactionSource, LocalIndication.current)
            .pointerInput(Unit) {
                detectTapGestures(
                    onLongPress = {
                        isContextMenuVisible = true
                        pressOffset = DpOffset(it.x.toDp(), it.y.toDp())
                    }, onPress = {
                        val press = PressInteraction.Press(it)
                        interactionSource.emit(press)
                        tryAwaitRelease()
                        interactionSource.emit(PressInteraction.Release(press))
                    })
            }
    ) {
        Column(
            modifier = Modifier
                .padding(15.dp)
        ) {
            Text(
                text = " ${item.name}",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )
            Spacer(modifier = Modifier.height(8.dp))

            item.specs?.let {
                Spacer(modifier = Modifier.height(0.dp))
                Text(
                    text = "${item.units} units •   ${it["color"]} •  ${it["storage"]}",
                    fontSize = 16.sp
                )
            }

        }

        DropdownMenu(
            expanded = isContextMenuVisible,
            onDismissRequest = {
                isContextMenuVisible = false
            },
            offset = pressOffset.copy(
                y = pressOffset.y - 40.dp // Adjust the offset as needed
            )
        ) {
            DropdownMenuItem(onClick = {
                controller.navigate("editm/$phoneName/${item.name}")
                isContextMenuVisible = false
            },text = { Text("Edit") })

            DropdownMenuItem(onClick = {
               val database= FirebaseDatabase.getInstance().reference.child("Inventory/Inventory/Phones/${phoneName}/${item.name}")
                database.removeValue()

                isContextMenuVisible = false
            },text = { Text("Delete") })
        }
    }
}
