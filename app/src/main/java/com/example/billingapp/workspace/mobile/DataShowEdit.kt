package com.example.billingapp.workspace.mobile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.billingapp.workspace.data.InventoryPhone



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ShowEditScreen(Data: InventoryPhone) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = Data.name)
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xffff6b00)
                ),
                navigationIcon = {
                    IconButton(onClick = { /* handle back button click */ }) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                }
            )
        }
    ) {paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            ShowMobileData(Data)

        }
    }
}
@Composable
fun ShowMobileData(Data: InventoryPhone) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
    ) {
        Text(
            text = "Name: ${Data.name}",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "Units: ${Data.units}",
            style = MaterialTheme.typography.bodyMedium
        )

        Data.specs?.let {
            Text(
                text = "Color: ${it["color"]}, Storage: ${it["storage"]}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview
@Composable
fun PreviewShowEditScreen() {
    val data = InventoryPhone(
        name = "Apple",
        units = 10,
        specs = mapOf("color" to "Black", "storage" to "128GB")
    )
    ShowEditScreen(data)
}
