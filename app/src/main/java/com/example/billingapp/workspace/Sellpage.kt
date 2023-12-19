package com.example.billingapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircleOutline
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


data class bill(
    val productname: String,
    var quatity: MutableState<Int>,
    val amount: Double,
)
val billList = List(10) { index ->
    bill(
        productname = "Product $index",
        quatity = mutableStateOf(0), // Adjust as needed
        amount = (index + 1) * 50.0 // Adjust as needed
    )
}
var total : Double = 0.0

class Sellpage {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun sell(){

        Scaffold(  topBar = {
            TopAppBar(
                modifier = Modifier,

                title = {

                    Text(text = "Sell Products")
                },

                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xffff6b00)
                ), navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Localized description"
                        )
                    }
                },
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.cart),
                            contentDescription = "Localized description",
                            modifier = Modifier.size(30.dp)
                        )
                    }
                }
            )
        }

        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues = paddingValues),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally
            ) { //there its start
                Property1Group17(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                        .requiredHeight(height = 337.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(color = Color(0xfffff0dd))
                ){
                    Box(modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxWidth()
                        .align(Alignment.TopCenter)
                        .requiredHeight(height = 260.dp) )
                    {
                        // bill list
                        billList()
                    }
                    Box(modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .fillMaxWidth()
                        .requiredHeight(77.dp))
                    {
                        // total
                        for(i in billList){
                            total = total + (i.amount * i.quatity.value)
                        }
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp)
                                .requiredHeight(40.dp)
                        ) {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .requiredHeight(40.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Total",
                                    modifier = Modifier
                                        .weight(1f)
                                        .offset(x = 25.dp),
                                       style = TextStyle(
                                        fontWeight = FontWeight.Bold)


                                )
                                Text(
                                    text = "",
                                    modifier = Modifier
                                        .weight(1f)
                                        .offset(x = 15.dp)

                                )

                                Text(text = "₹ ${total}",
                                    modifier = Modifier.weight(1f),
                                    style = TextStyle(
                                    fontWeight = FontWeight.Bold)
                                        )

                            }
                        }
                    }

                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 23.dp)
                        .offset(y = 25.dp)
                        .requiredHeight(height = 150.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(color = Color(0xfffff0dd))
                ){

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(10.dp)
                            .requiredHeight(100.dp)
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 40.dp, vertical = 15.dp)
                                .requiredHeight(19.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(text = "Total",
                                modifier = Modifier.weight(1f),
                                style = TextStyle(
                                fontWeight = FontWeight.Bold)
                            )
                            Text(text = "",
                                modifier = Modifier.weight(1f))
                            Text(text = "${total}",
                                modifier = Modifier.weight(1f),
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 40.dp, vertical = 15.dp)
//                                .offset(y=-10.dp)
                                .requiredHeight(19.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(text = "Discount",
                                modifier = Modifier.weight(1f),
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold)
                            )
                            Text(text = "",
                                modifier = Modifier.weight(1f))
                            Text(text = "${0}",
                                modifier = Modifier.weight(1f),
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold)
                            )
                        }
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 40.dp, vertical = 15.dp)
//                                .offset(y=-10.dp)
                                .requiredHeight(19.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ){
                            Text(text = "Bill",
                                modifier = Modifier.weight(1f),
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold)
                            )
                            Text(text = "",
                                modifier = Modifier.weight(1f))
                            Text(text = "${total}",
                                modifier = Modifier.weight(1f),
                                style = TextStyle(
                                    fontWeight = FontWeight.Bold)
                            )
                        }
                    }
                }
                //there it end
             }


        }
    }
    @OptIn(ExperimentalMaterialApi::class)
    @Composable
    fun billList() {


        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
            ) {
                itemsIndexed(billList) { index, bill ->
                    androidx.compose.material.ListItem(
                        text = {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(3.dp)
                                    .requiredHeight(20.dp)
                            ) {
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(
                                        text = "${bill.productname}",
                                        modifier = Modifier.weight(1f)
                                    )
                                    Box(
                                        modifier = Modifier.weight(1f)
                                    ) {
                                        Row(
                                            modifier = Modifier.fillMaxWidth(),
                                            horizontalArrangement = Arrangement.SpaceBetween
                                        ){
                                        IconButton(
                                            onClick = { bill.quatity.value++ },
                                            modifier = Modifier.weight(1f)
                                        ) {
                                            Icon(
                                                imageVector = Icons.Default.AddCircleOutline,
                                                contentDescription = "add"
                                            )
                                        }
                                        Text(
                                            text = "${bill.quatity.value}",
//
                                        )
                                        IconButton(
                                            onClick = { bill.quatity.value-- },
                                            modifier = Modifier.weight(1f)

                                        ) {
                                            Icon(
                                                painter = painterResource(id = R.drawable.minus),
                                                contentDescription = "add",
                                                modifier = Modifier.size(30.dp)

                                            )
                                        }
                                    }  }
                                    Text(
                                        text = "${bill.amount}",
                                        modifier = Modifier.weight(1f)
                                    )
                                }
                            }
                        },
                        modifier = Modifier
                            .fillMaxWidth()

                    )
                }
            }
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Property1Group17(modifier: Modifier) {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            label = { Text("Available Items") },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            },
            trailingIcon = {
                if (text.isNotEmpty()) {
                    IconButton(
                        onClick = {
                            text = ""
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = "Clear"
                        )
                    }
                }
            },
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = Color(0xffff6b00),
                unfocusedBorderColor = Color.Gray,
                focusedLabelColor = Color(0xffff6b00),
                unfocusedLabelColor = Color.Gray,
            )

        )


    }
@Preview
@Composable
fun sellPreview(){
    sell()
}
}