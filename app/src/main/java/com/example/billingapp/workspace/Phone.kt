package com.example.billingapp.workspace

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.billingapp.functions.DataViewModel
import com.example.billingapp.workspace.data.Inventory
import com.example.billingapp.workspace.data.PhoneDetails

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneInventory() {
    val viewModel: DataViewModel = viewModel()

    DisposableEffect(Unit) {
        viewModel.fetchInventoryData()
        onDispose { /* cleanup, if needed */ }
    }

    val inventoryData by rememberUpdatedState(newValue = viewModel.inventoryData.value)
    val loading by rememberUpdatedState(newValue = viewModel.loading.value)

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
                    IconButton(onClick = { /* handle back button click */ }) {
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
                .padding(paddingValues = paddingValues)
        ) {
            if (loading) {
                // Display a loading indicator or message
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                PhoneList(inventoryData)
            }
        }
    }
}

@Composable
fun PhoneList(inventoryData: Inventory?) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        if (inventoryData == null) {
            // Display a message when the data is null or empty
            Text("No data available")
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                // Display brand header (optional)
                if (inventoryData.phones.apple.isNotEmpty()) {
                    item {
                        Text(
                            text = "Apple Phones",
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(horizontal = 16.dp),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                // List all phones under "Apple"
                items(inventoryData.phones.apple.toList()) { (phoneName, phoneDetails) ->
                    PhoneListItem(phoneName, phoneDetails)
                }

                // Display brand header for Samsung (optional)
                if (inventoryData.phones.samsung.isNotEmpty()) {
                    item {
                        Text(
                            text = "Samsung Phones",
                            modifier = Modifier
                                .padding(bottom = 8.dp)
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(horizontal = 16.dp),
                            fontWeight = FontWeight.Bold
                        )
                    }
                }

                // List all phones under "Samsung"
                items(inventoryData.phones.samsung.toList()) { (phoneName, phoneDetails) ->
                    PhoneListItem(phoneName, phoneDetails)
                }
            }
        }
    }
}

@Composable
fun PhoneListItem(phoneName: String, phoneDetails: PhoneDetails) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { /* handle click */ },
        shape = MaterialTheme.shapes.medium,
//        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = phoneName,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Units: ${phoneDetails.units}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Color: ${phoneDetails.specs.color}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Storage: ${phoneDetails.specs.storage}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
