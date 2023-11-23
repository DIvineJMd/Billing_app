package com.example.billingapp

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.billingapp.ui.theme.BillingAppTheme


    @Composable
    fun Log(state: LoginState, onSignInCIick: ( )-> Unit) {
        val context = LocalContext.current
        LaunchedEffect(key1 = state.signinError ){
            state.signinError?.let{error->
                Toast.makeText(
                    context,
                    error,
                    Toast.LENGTH_LONG
                ).show()
            }
        }


        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(modifier = Modifier.padding(vertical = 80.dp),
                    text = "SATGURU",
                    style = TextStyle(fontSize = 28.sp, color = Color(0xFFFF6B00), fontWeight = FontWeight.SemiBold)
                )
                Text(
                    text = " TELECOM",
                    style = TextStyle(fontSize = 28.sp, color = Color(0xFF515151), fontWeight = FontWeight.SemiBold)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            val portalText = "Google Login"
            Text(text = portalText, fontSize = 25.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(16.dp))

            // Display the error message

            Spacer(modifier = Modifier.height(20.dp))

            Spacer(modifier = Modifier.height(28.dp))
            Button(
                onClick = {
                    onSignInCIick()
                },
                modifier = Modifier
                    .padding(10.dp)
                    .height(50.dp)
                    .width(280.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFFF6B00)
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "Login ",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White
                    )
                )
            }
        }
    }


@Preview
@Composable
fun LoginPageAdminPreview() {
    BillingAppTheme {
//        val navController = rememberNavController()
//            Log()
    }
}