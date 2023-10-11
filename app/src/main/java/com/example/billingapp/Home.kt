package com.example.billingapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredSize
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Home {
    @Composable
    fun HomeScreen(modifier: Modifier = Modifier) {
        Box(
            modifier = modifier
                .requiredWidth(width = 390.dp)
                .requiredHeight(height = 844.dp)
                .background(color = Color(0xfffcfcfc))
        ) {
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
                        fontSize = 12.sp)
                    ) {append("Apps")}},
                modifier = Modifier
                    .align(alignment = Alignment.Center)
                    .offset(x = 0.5.dp,
                        y = 402.5.dp)
                    .requiredWidth(width = 319.dp)
                    .requiredHeight(height = 23.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically))
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 21.dp,
                        y = 595.dp)
                    .requiredWidth(width = 346.dp)
                    .requiredHeight(height = 43.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 346.dp)
                        .requiredHeight(height = 43.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.BottomCenter)
                            .offset(x = 0.dp,
                                y = 0.dp)
                            .requiredWidth(width = 346.dp)
                            .requiredHeight(height = 43.dp)
                            .clip(shape = RoundedCornerShape(5.dp))
                            .background(color = Color(0xfffcfcfc))
                            .border(border = BorderStroke(1.dp, Color(0xff009638)),
                                shape = RoundedCornerShape(5.dp)
                            ))
                    Text(
                        text = "Facing issue? Contact Us",
                        color = Color(0xff009638),
                        style = TextStyle(
                            fontSize = 12.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.BottomCenter)
                            .offset(x = 4.dp,
                                y = (-14).dp)
                            .wrapContentHeight(align = Alignment.CenterVertically))
                }
//                Image(
//                    painter = painterResource(id = R.drawable.whatsapp),
//                    contentDescription = "whatsapp 1",
//                    modifier = Modifier
//                        .align(alignment = Alignment.BottomCenter)
//                        .offset(x = (-86).dp,
//                            y = (-11).dp)
//                        .requiredSize(size = 20.dp))
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 13.dp,
                        y = 354.dp)
                    .requiredWidth(width = 365.dp)
                    .requiredHeight(height = 199.dp)
            ) {
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 0.dp,
                            y = 29.dp)
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
                        .offset(x = 14.dp,
                            y = 0.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically))
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 255.dp,
                            y = 51.dp)
                        .requiredWidth(width = 100.dp)
                        .requiredHeight(height = 130.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 100.dp)
                            .requiredHeight(height = 130.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = Color.White)
                            .border(border = BorderStroke(1.dp, Color(0xffa5a5a5)),
                                shape = RoundedCornerShape(10.dp)
                            ))
                    Text(
                        text = "1",
                        color = Color(0xff3f3f3f),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 14.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 46.dp,
                                y = 89.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically))
                    Text(
                        text = "Active Staff",
                        color = Color(0xffa3695c),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 18.dp,
                                y = 60.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically))
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 35.dp,
                                y = 16.dp)
                            .requiredSize(size = 30.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 30.dp)
                                .clip(shape = CircleShape)
                                .background(color = Color(0xffff8c00)))
                        Image(
                            painter = painterResource(id = R.drawable.frame),
                            contentDescription = "Frame",
                            modifier = Modifier
                                .fillMaxSize()
//                                .padding(start = 306.dp,
//                                    end = -300.dp,
//                                    top = 424.dp,
//                                    bottom = -418.dp)
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 9.dp,
                            y = 51.dp)
                        .requiredWidth(width = 100.dp)
                        .requiredHeight(height = 130.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 100.dp)
                            .requiredHeight(height = 130.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = Color.White)
                            .border(border = BorderStroke(1.dp, Color(0xffa5a5a5)),
                                shape = RoundedCornerShape(10.dp)
                            ))
                    Text(
                        text = "Bills Made",
                        color = Color(0xffa3695c),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 20.dp,
                                y = 60.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically))
                    Text(
                        text = "254",
                        color = Color(0xff3f3f3f),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 14.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 38.dp,
                                y = 89.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically))
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 35.dp,
                                y = 17.dp)
                            .requiredSize(size = 30.dp)
                            .clip(shape = CircleShape)
                            .background(color = Color(0xffff8c00)))
                    Image(
                        painter = painterResource(id = R.drawable.bill1),
                        contentDescription = "bill_made",
                        modifier = Modifier
                            .align(alignment = Alignment.Center)
                            .offset(x = (-0.5).dp,
                                y = (-32.81480407714844).dp)
                            .requiredWidth(width = 30.dp)
                            .requiredHeight(height = 35.dp))
                }
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 132.dp,
                            y = 51.dp)
                        .requiredWidth(width = 100.dp)
                        .requiredHeight(height = 130.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 100.dp)
                            .requiredHeight(height = 130.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = Color.White)
                            .border(border = BorderStroke(1.dp, Color(0xffa5a5a5)),
                                shape = RoundedCornerShape(10.dp)
                            ))
                    Text(
                        text = "5640",
                        color = Color(0xff3f3f3f),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 14.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 33.dp,
                                y = 89.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically))
                    Text(
                        text = "Sales",
                        color = Color(0xffa3695c),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 35.dp,
                                y = 60.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically))
                    Box(
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 35.dp,
                                y = 16.dp)
                            .requiredSize(size = 30.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .requiredSize(size = 30.dp)
                                .clip(shape = CircleShape)
                                .background(color = Color(0xffff8c00)))
                        Image(
                            painter = painterResource(id = R.drawable.frame),//sales
                            contentDescription = "Frame",
                            colorFilter = ColorFilter.tint(Color(0xff4d4d4d)),
                            modifier = Modifier
                                .align(alignment = Alignment.TopStart)
                                .offset(x = 4.dp,
                                    y = 4.dp)
                                .requiredSize(size = 24.dp))
                    }
                }
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 269.dp,
                            y = 0.dp)
                        .requiredWidth(width = 86.dp)
                        .requiredHeight(height = 24.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 86.dp)
                            .requiredHeight(height = 24.dp)
                            .clip(shape = RoundedCornerShape(topStart = 2.dp, topEnd = 2.dp))
                            .background(color = Color(0xfffff0dd)))
                    Text(
                        text = "Today",
                        color = Color(0xff666666),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 14.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 7.dp,
                                y = 2.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically))
                    Divider(
                        color = Color(0xffa5a5a5),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 0.dp,
                                y = 24.dp)
                            .requiredWidth(width = 86.dp))
                    Image(
                        painter = painterResource(id = R.drawable.chevrondown),
                        contentDescription = "chevron-down",
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 55.dp,
                                y = 0.dp)
                            .requiredSize(size = 24.dp))
                }
            }
            Box(
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 13.dp,
                        y = 126.dp)
                    .requiredWidth(width = 365.dp)
                    .requiredHeight(height = 199.dp)
            ) {
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 0.dp,
                            y = 29.dp)
                        .requiredWidth(width = 365.dp)
                        .requiredHeight(height = 170.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                        .background(color = Color(0xfffff0dd)))
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 9.dp,
                            y = 49.dp)
                        .requiredWidth(width = 100.dp)
                        .requiredHeight(height = 130.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 100.dp)
                            .requiredHeight(height = 130.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = Color.White)
                            .border(border = BorderStroke(1.dp, Color(0xffa5a5a5)),
                                shape = RoundedCornerShape(10.dp)
                            ))
                    Text(
                        text = "Inventory",
                        color = Color(0xffa3695c),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 22.dp,
                                y = 101.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically))
//                    Image(
//                        painter = painterResource(id = R.drawable.management1),
//                        contentDescription = "management 1",
//                        modifier = Modifier
//                            .align(alignment = Alignment.TopStart)
//                            .offset(x = 25.dp,
//                                y = 36.dp)
//                            .requiredSize(size = 51.dp))
                }
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 255.dp,
                            y = 49.dp)
                        .requiredWidth(width = 100.dp)
                        .requiredHeight(height = 130.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 100.dp)
                            .requiredHeight(height = 130.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = Color.White)
                            .border(border = BorderStroke(1.dp, Color(0xffa5a5a5)),
                                shape = RoundedCornerShape(10.dp)
                            ))
                    Text(
                        text = "Loans",
                        color = Color(0xffa3695c),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 33.dp,
                                y = 101.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically))
//                    Image(
//                        painter = painterResource(id = R.drawable.businessreport1),
//                        contentDescription = "business-report 1",
//                        modifier = Modifier
//                            .align(alignment = Alignment.Center)
//                            .offset(x = 0.5.dp,
//                                y = (-3.3148040771484375).dp)
//                            .requiredSize(size = 51.dp))
                }
                Box(
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 132.dp,
                            y = 49.dp)
                        .requiredWidth(width = 100.dp)
                        .requiredHeight(height = 130.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .requiredWidth(width = 100.dp)
                            .requiredHeight(height = 130.dp)
                            .clip(shape = RoundedCornerShape(10.dp))
                            .background(color = Color.White)
                            .border(border = BorderStroke(1.dp, Color(0xffa5a5a5)),
                                shape = RoundedCornerShape(10.dp)
                            ))
                    Text(
                        text = "Bills",
                        color = Color(0xffa3695c),
                        textAlign = TextAlign.Center,
                        style = TextStyle(
                            fontSize = 12.sp),
                        modifier = Modifier
                            .align(alignment = Alignment.TopStart)
                            .offset(x = 38.dp,
                                y = 101.dp)
                            .wrapContentHeight(align = Alignment.CenterVertically))
//                    Image(
//                        painter = painterResource(id = R.drawable.bill1),
//                        contentDescription = "bill 1",
//                        modifier = Modifier
//                            .align(alignment = Alignment.Center)
//                            .offset(x = (-0.2784423828125).dp,
//                                y = (-6.0932464599609375).dp)
//                            .requiredSize(size = 51.dp))
                }
                Text(
                    text = "Quick Buttons",
                    color = Color(0xff2e2e2e),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 16.sp),
                    modifier = Modifier
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 9.dp,
                            y = 0.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically))
            }
            Box(
                modifier = Modifier
                    .requiredWidth(width = 390.dp)
                    .requiredHeight(height = 80.dp)
            ) {
                Box(
                    modifier = Modifier
                        .requiredWidth(width = 390.dp)
                        .requiredHeight(height = 80.dp)
                        .statusBarsPadding()
                        .background(brush = Brush.radialGradient(
                            0f to Color(0xffff8c00),
                            1f to Color(0xffff723f),
                            center = Offset(200f, 40f),
                            radius = 195f)))
//                Image(
//                    painter = painterResource(id = R.drawable.frame),
//                    contentDescription = "Frame",
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .padding(start = 10.dp,
//                            end = 328.dp,
//                            top = 15.dp,
//                            bottom = 13.dp))
                Text(
                    text = "22AAAAA0000A1Z5",
                    color = Color(0xffd1dfa8),
                    style = TextStyle(
                        fontSize = 14.sp),
                    modifier = Modifier.statusBarsPadding()
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 64.dp,
                            y = 43.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically))
//                Icon(
//                    painter = painterResource(id = R.drawable.property1newnotif1),
//                    contentDescription = "Notification Bell",
//                    modifier = Modifier
//                        .align(alignment = Alignment.TopStart)
//                        .offset(x = 344.dp,
//                            y = 28.dp)
//                        .requiredSize(size = 25.dp))
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
                    modifier = Modifier.statusBarsPadding()
                        .align(alignment = Alignment.TopStart)
                        .offset(x = 64.dp,
                            y = 8.dp)
                        .wrapContentHeight(align = Alignment.CenterVertically))
            }
        }
    }

    @Preview
    @Composable
    private fun HomeScreenPreview() {
        HomeScreen(Modifier)
    }
}