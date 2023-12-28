package com.example.billingapp.workspace.accessories

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.billingapp.workspace.data.AccessoriesItem
import com.google.firebase.database.*


class Ass {
    class AccessoriesViewModel(category: String) : ViewModel() {
        constructor() : this("")
        private val database =
            FirebaseDatabase.getInstance().reference.child("Inventory/Accessories/$category")
        private val _accessoriesItems = mutableStateOf(emptyList<AccessoriesItem>())
        val accessoriesItems: List<AccessoriesItem> get() = _accessoriesItems.value
        var loading by mutableStateOf(true)

        init {
            loadData()
        }

        private fun loadData() {
            val accessoriesListener = object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val items = mutableListOf<AccessoriesItem>()

                    for (productSnapshot in snapshot.children) {
                        val name = productSnapshot.key.toString()
                        val units = productSnapshot.child("quantity").getValue<Long?>() ?: 0
                        val price = productSnapshot.child("price").getValue<Float?>() ?: 0.0f

                        items.add(AccessoriesItem(name, units.toInt(), price))
                    }

                    _accessoriesItems.value = items
                    loading = false
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle error
                    loading = false
                }
            }

            database.addValueEventListener(accessoriesListener)
        }
        fun getSuggestions(input: String): List<String> {
            return accessoriesItems
                .map { it.name }
                .filter { it.contains(input, ignoreCase = true) }.take(5)
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun AccessoriesInventory(category: String, controller: NavController) {
        val accessoriesViewModel: AccessoriesViewModel = viewModel(factory = ViewModelFactory(category))

        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(text = "Accessories Inventory")
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(
                        containerColor = Color(0xffff6b00)
                    ),
                    navigationIcon = {
                        IconButton(onClick = { controller.popBackStack() }) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
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
                if (accessoriesViewModel.loading) {
                    // Loading state
                    CircularProgressIndicator(
                        modifier = Modifier.size(50.dp),
                    )
                } else if (accessoriesViewModel.accessoriesItems.isEmpty()) {
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
                        items(accessoriesViewModel.accessoriesItems) { item ->
                            AccessoriesItemRow(item,controller)
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

    class ViewModelFactory(private val category: String) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(AccessoriesViewModel::class.java)) {
                return AccessoriesViewModel(category) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class")
        }
    }

    @Composable
    fun AccessoriesItemRow(item: AccessoriesItem,controller: NavController) {
        Card(
            elevation =  CardDefaults.cardElevation(defaultElevation = 5.dp,
                pressedElevation = 12.dp,
                focusedElevation = 10.dp,
                hoveredElevation = 10.dp,
                draggedElevation = 10.dp,
                disabledElevation = 4.dp),
            colors=CardColors(containerColor = Color(0xFFFFBBA6)
                , contentColor = Color(0xFF2E2E2E)
                , disabledContainerColor = Color(0xFF6BBCC7)
                ,disabledContentColor=Color(0xFF6BBCC7)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(7.5.dp)
                .clickable {}

        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
            ) {
                Text(
                    text = " ${item.name}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "${item.units} units • ₹ ${item.price} ",
                    fontSize = 16.sp
                )

            }
        }
    }

}