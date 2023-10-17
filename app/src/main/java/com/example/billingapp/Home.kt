package com.example.billingapp

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
class Home {
    @Composable
    fun HomeScreen(modifier: Modifier = Modifier) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .fillMaxHeight()
                .background(MaterialTheme.colorScheme.background)
              )
         {

            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .requiredHeight(height = 80.dp)
                        .statusBarsPadding()
                        .background(
                            brush = Brush.radialGradient(
                                0f to Color(0xffff8c00),
                                1f to Color(0xffff723f),
                                center = Offset(200f, 80f),
                                radius = 195f
                            )
                        ))
                IconButton(
                    onClick = { /* Handle click here */ },
                    modifier = modifier
                        .padding(top=18.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.menu),
                        contentDescription = "Menu",
                        modifier = Modifier
                            .size(30.dp) // Set size directly on the Icon
                    )
                }

                Text(
                    text = "22AAAAA0000A1Z5",
                    color = Color(0xffd1dfa8),
                    style = TextStyle(
                        fontSize = 14.sp),
                    modifier = Modifier
                        .statusBarsPadding()
                        .align(alignment = Alignment.TopStart)
                        .offset(
                            x = 64.dp,
                            y = 43.dp
                        )
                        .wrapContentHeight(align = Alignment.CenterVertically))

                Icon(
                    painter = painterResource(id = R.drawable.property1newnotif1),
                    contentDescription = "Notification Bell",
                    modifier = Modifier
                        .align(alignment = Alignment.TopEnd)
                        .offset(x = (-16).dp, y = 26.dp)
                        .requiredSize(size = 25.dp)
                )
                Text(
                    textAlign = TextAlign.Center,
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(
                            color = Color.White,
                            fontSize = 18.sp)
                        ) {append("SATGURU")}
                        withStyle(style = SpanStyle(
                            color = Color(0xff515151),
                            fontSize = 32.sp)
                        ) {append(" ")}
                        withStyle(style = SpanStyle(
                            color = Color(0xff424242),
                            fontSize = 16.sp)
                        ) {append("TELECOM")}},
                    modifier = Modifier
                        .statusBarsPadding()
                        .align(alignment = Alignment.TopStart)
                        .offset(
                            x = 64.dp,
                            y = 8.dp
                        )
                        .wrapContentHeight(align = Alignment.CenterVertically))
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopCenter)
                        .offset(
                            x = 0.dp,
                            y = 126.dp
                        )
                        .requiredWidth(width = 365.dp)
                        .requiredHeight(height = 199.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 0.dp,
                                y = 29.dp
                            )
                            .fillMaxWidth()
                            .requiredHeight(height = 170.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = Color(0xfffff0dd)))
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 9.dp,
                                y = 49.dp
                            )
                            .requiredWidth(width = 100.dp)
                            .requiredHeight(height = 130.dp)
                    )
                    {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 100.dp)
                                .requiredHeight(height = 130.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = Color.White)
                                .border(
                                    border = BorderStroke(1.dp, Color(0xffa5a5a5)),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .clickable { /* Handle */ }
                        )
                        Text(
                            text = "Inventory",
                            color = Color(0xffa3695c),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 22.dp,
                                    y = 101.dp
                                )
                                .wrapContentHeight(align = Alignment.CenterVertically))
                        Image(
                            painter = painterResource(id = R.drawable.management1),
                            contentDescription = "management 1",
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 25.dp,
                                    y = 36.dp
                                )
                                .requiredSize(size = 51.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 255.dp,
                                y = 49.dp
                            )
                            .requiredWidth(width = 100.dp)
                            .requiredHeight(height = 130.dp)
                    ) {
                        Box( modifier = Modifier
                            .requiredWidth(width = 100.dp)
                            .requiredHeight(height = 130.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = Color.White)
                            .border(
                                border = BorderStroke(1.dp, Color(0xffa5a5a5)),
                                shape = RoundedCornerShape(10.dp)
                            )
                            .clickable { /* Handle */ })
                        Text(
                            text = "Loans",
                            color = Color(0xffa3695c),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 33.dp,
                                    y = 101.dp
                                )
                                .wrapContentHeight(align = Alignment.CenterVertically))
                        Image(
                            painter = painterResource(id = R.drawable.businessreport1),
                            contentDescription = "business-report 1",
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(
                                    x = 0.5.dp,
                                    y = (-3.3148040771484375).dp
                                )
                                .requiredSize(size = 51.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 132.dp,
                                y = 49.dp
                            )
                            .requiredWidth(width = 100.dp)
                            .requiredHeight(height = 130.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 100.dp)
                                .requiredHeight(height = 130.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = Color.White)
                                .border(
                                    border = BorderStroke(1.dp, Color(0xffa5a5a5)),
                                    shape = RoundedCornerShape(10.dp)
                                )
                                .clickable { /* Handle */ })
                        Text(
                            text = "Bills",
                            color = Color(0xffa3695c),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 38.dp,
                                    y = 101.dp
                                )
                                .wrapContentHeight(align = Alignment.CenterVertically))
                        Image(
                            painter = painterResource(id = R.drawable.bill),
                            contentDescription = "bill 1",
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(
                                    x = (-0.2784423828125).dp,
                                    y = (-6.0932464599609375).dp
                                )
                                .requiredSize(size = 51.dp))
                    }
                    Text(
                        text = "Quick Buttons",
                        color = Color(0xff2e2e2e),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 16.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 9.dp,
                                y = 0.dp
                            )
                            .wrapContentHeight(align = Alignment.CenterVertically))
                }
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopCenter)
                        .offset(
                            x = 0.dp,
                            y = 354.dp
                        )
                        .requiredWidth(width = 365.dp)
                        .requiredHeight(height = 199.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 0.dp,
                                y = 29.dp
                            )
                            .requiredWidth(width = 365.dp)
                            .requiredHeight(height = 170.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = Color(0xfffff0dd)))
                    Text(
                        text = "Quick Report",
                        color = Color(0xff2e2e2e),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 16.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 14.dp,
                                y = 0.dp
                            )
                            .wrapContentHeight(align = Alignment.CenterVertically))
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 255.dp,
                                y = 51.dp
                            )
                            .requiredWidth(width = 100.dp)
                            .requiredHeight(height = 130.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 100.dp)
                                .requiredHeight(height = 130.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = Color.White)
                                .border(
                                    border = BorderStroke(1.dp, Color(0xffa5a5a5)),
                                    shape = RoundedCornerShape(10.dp)
                                )

                        )
                        Text(
                            text = "1",
                            color = Color(0xff3f3f3f),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 46.dp,
                                    y = 89.dp
                                )
                                .wrapContentHeight(align = Alignment.CenterVertically))
                        Text(
                            text = "Active Staff",
                            color = Color(0xffa3695c),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 18.dp,
                                    y = 60.dp
                                )
                                .wrapContentHeight(align = Alignment.CenterVertically))
                        Box(
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 35.dp,
                                    y = 16.dp
                                )
                                .requiredSize(size = 30.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .requiredSize(size = 40.dp)
                                    .clip(shape = CircleShape)
                                    .background(color = Color(0xffff8c00)))
                            Image(
                                painter = painterResource(id = R.drawable.frame),
                                contentDescription = "Frame",
                                modifier = Modifier
                                    .fillMaxSize()

                            )
                        }
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 9.dp,
                                y = 51.dp
                            )
                            .requiredWidth(width = 100.dp)
                            .requiredHeight(height = 130.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 100.dp)
                                .requiredHeight(height = 130.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = Color.White)
                                .border(
                                    border = BorderStroke(1.dp, Color(0xffa5a5a5)),
                                    shape = RoundedCornerShape(10.dp)
                                ))
                        Text(
                            text = "Bills Made",
                            color = Color(0xffa3695c),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 20.dp,
                                    y = 60.dp
                                )
                                .wrapContentHeight(align = Alignment.CenterVertically))
                        Text(
                            text = "254",
                            color = Color(0xff3f3f3f),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 38.dp,
                                    y = 89.dp
                                )
                                .wrapContentHeight(align = Alignment.CenterVertically))
                        Box(
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 28.dp,
                                    y = 10.dp
                                )
                                .requiredSize(size = 40.dp)
                                .clip(shape = CircleShape)
                                .background(color = Color(0xffff8c00)))
                        Image(
                            painter = painterResource(id = R.drawable.bill1),
                            contentDescription = "bill_made",
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .offset(
                                    x = (0.0).dp,
                                    y = (-35.81480407714844).dp
                                )
                                .requiredWidth(width = 25.dp)
                                .requiredHeight(height = 30.dp))
                    }
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 132.dp,
                                y = 51.dp
                            )
                            .requiredWidth(width = 100.dp)
                            .requiredHeight(height = 130.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 100.dp)
                                .requiredHeight(height = 130.dp)
                                .clip(shape = RoundedCornerShape(10.dp))
                                .background(color = Color.White)
                                .border(
                                    border = BorderStroke(1.dp, Color(0xffa5a5a5)),
                                    shape = RoundedCornerShape(10.dp)
                                )

                        )
                        Text(
                            text = "5640",
                            color = Color(0xff3f3f3f),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontSize = 14.sp),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 33.dp,
                                    y = 89.dp
                                )
                                .wrapContentHeight(align = Alignment.CenterVertically))
                        Text(
                            text = "Sales",
                            color = Color(0xffa3695c),
                            textAlign = TextAlign.Center,
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 35.dp,
                                    y = 60.dp
                                )
                                .wrapContentHeight(align = Alignment.CenterVertically))
                        Box(
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(
                                    x = 35.dp,
                                    y = 16.dp
                                )
                                .requiredSize(size = 30.dp)
                        ) {
                            Box(
                                modifier = Modifier
                                    .requiredSize(size = 40.dp)
                                    .clip(shape = CircleShape)
                                    .background(color = Color(0xffff8c00)))
                            Image(
                                painter = painterResource(id = R.drawable.rupee),//sales
                                contentDescription = "Frame",
                                colorFilter = ColorFilter.tint(Color(0xff4d4d4d)),
                                modifier = Modifier
                                    .align(alignment = Alignment.TopStart)
                                    .offset(
                                        x = 4.dp,
                                        y = 4.dp
                                    )
                                    .requiredSize(size = 24.dp))
                        }
                    }

                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(
                                x = 269.dp,
                                y = 0.dp
                            )
                            .requiredWidth(width = 86.dp)
                            .requiredHeight(height = 24.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredWidth(width = 86.dp)
                                .requiredHeight(height = 24.dp)
                                .clip(shape = RoundedCornerShape(topStart = 2.dp, topEnd = 2.dp))
                                .background(color = Color(0xfffff0dd)))
                      //yaha
                        Text(modifier = Modifier.padding(3.dp).offset(x=6.dp,y=0.dp), text = "Today")
                        dropdown()
                    }
                }
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopCenter)
                        .offset(
                            x = 0.dp,
                            y = 595.dp
                        )
                        .requiredWidth(width = 346.dp)
                        .requiredHeight(height = 43.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center)
                            .background(MaterialTheme.colorScheme.background)
                    )
                    {
                        Box(
                            modifier = Modifier
                                .align(alignment = Alignment.BottomCenter)
                                .offset(
                                    x = 0.dp,
                                    y = 0.dp
                                )
                                .requiredWidth(width = 346.dp)
                                .requiredHeight(height = 43.dp)
                                .clip(shape = RoundedCornerShape(5.dp))
                                .background(color = Color(0xfffcfcfc))
                                .border(
                                    border = BorderStroke(2.dp, Color(0xff009638)),
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .clickable { /* Handle */ })
                        Text(
                            text = "Facing issue? Contact Us",
                            color = Color(0xff009638),
                            style = TextStyle(
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 12.sp),
                            modifier = Modifier
                                .align(alignment = Alignment.BottomCenter)
                                .offset(
                                    x = 4.dp,
                                    y = (-14).dp
                                )
                                .wrapContentHeight(align = Alignment.CenterVertically))
                    }
                    Image(
                        painter = painterResource(id = R.drawable.whatsapp),
                        contentDescription = "whatsapp 1",
                        modifier = Modifier
                            .align(alignment = Alignment.BottomCenter)
                            .offset(
                                x = (-86).dp,
                                y = (-11).dp
                            )
                            .requiredSize(size = 20.dp))
                }
                Text(
                    textAlign = TextAlign.Center,
                    text = buildAnnotatedString {
                        withStyle(style = SpanStyle(
                            color = Color.Black,
                            fontSize = 12.sp)
                        ) {append("Developed by ")}
                        withStyle(style = SpanStyle(
                            color = Color(0xff0057ff),
                            fontSize = 12.sp)
                        ) {append("Innov8")}
                        withStyle(style = SpanStyle(
                            color = Color(0xffff8a00),
                            fontSize = 12.sp,
                            fontStyle = FontStyle.Italic

                        )
                        ) {append("Apps")}},
                    modifier = Modifier
                        .align(alignment = Alignment.Center)
                        .offset(
                            x = 0.5.dp,
                            y = 365.5.dp
                        )
                        .requiredWidth(width = 319.dp)
                        .requiredHeight(height = 23.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically))}
        }
    }
    @Composable
    fun dropdown() {
        val listItems = arrayOf("This Week", "This Month")
        val disabledItem = 2
        val contextForToast = LocalContext.current.applicationContext

        // State of the selected item and the menu
        var selectedItem by remember { mutableStateOf(listItems[0]) }
        var expanded by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .requiredWidth(width = 86.dp)
                .requiredHeight(height = 24.dp),
            contentAlignment = Alignment.BottomEnd
        ) {

            // 3 vertical dots icon
            IconButton(onClick = {
                expanded = true
            }) {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Open Options"
                )
            }

            // Drop down menu
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = {
                    expanded = false
                }
            ) {
                // Adding items
                listItems.forEachIndexed { itemIndex, itemValue ->
                    DropdownMenuItem(
                        onClick = {
                            // Update the selected item
                            selectedItem = itemValue
                            expanded = false

                            // Perform actions or updates based on the selected item
                            when (itemValue) {
                                "This Week" -> {
                                    // Handle the "This Week" selection
                                    // Update your UI accordingly
                                }
                                "This Month" -> {
                                    // Handle the "This Month" selection
                                    // Update your UI accordingly
                                }
                            }

                            Toast.makeText(contextForToast, itemValue, Toast.LENGTH_SHORT)
                                .show()
                        },
                        enabled = (itemIndex != disabledItem)
                    ) {
                        Text(text = itemValue)
                    }
                }
            }

            // Conditionally render components based on the selected item
            when (selectedItem) {
                "This Week" -> {
                    // Render components for "This Week" selection
                }
                "This Month" -> {
                    // Render components for "This Month" selection
                }
            }
        }
    }
    @Preview
    @Composable
    private fun HomeScreenPreview() {
        HomeScreen(Modifier)
    }
}