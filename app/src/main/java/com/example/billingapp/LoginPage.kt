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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.billingapp.ui.theme.BillingAppTheme

class LoginPage(private val navController: NavHostController) {
    @Composable
    fun content() {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "SATGURU",
                    style = TextStyle(fontSize = 28.sp, color = Color(0xFFFF6B00), fontWeight = FontWeight.SemiBold)
                )
                Text(
                    text = " TELECOM",
                    style = TextStyle(fontSize = 28.sp, color = Color(0xFF515151), fontWeight = FontWeight.SemiBold)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                onClick = {
                    navController.navigate("adminPage") // Navigate to the AdminPage
                },
                modifier = Modifier
                    .padding(10.dp)
                    .height(50.dp)
                    .width(500.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFFF6B00)
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "Login as Admin",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    navController.navigate("userPage") // Navigate to the UserPage
                },
                modifier = Modifier
                    .padding(10.dp)
                    .height(50.dp)
                    .width(500.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFFF6B00)
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(
                    text = "Login as User",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White
                    )
                )
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Log(userType: Char) {
        var username by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "SATGURU",
                    style = TextStyle(fontSize = 28.sp, color = Color(0xFFFF6B00), fontWeight = FontWeight.SemiBold)
                )
                Text(
                    text = " TELECOM",
                    style = TextStyle(fontSize = 28.sp, color = Color(0xFF515151), fontWeight = FontWeight.SemiBold)
                )
            }
            Spacer(modifier = Modifier.height(30.dp))

            val portalText = if (userType == 'u') "User Portal" else "Admin Portal"
            Text(text = portalText, fontSize = 25.sp, color = Color.Black)

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text("Username") }
            )
            Spacer(modifier = Modifier.height(40.dp))
            TextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Enter password") },
                visualTransformation = PasswordVisualTransformation('*'),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(
                onClick = {
                    // Handle button click action here
                    // You can navigate here based on userType
                    // Example: navController.navigate("AdminPage")
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
}

@Preview
@Composable
fun LoginPageAdminPreview() {
    BillingAppTheme {
        val navController = rememberNavController()
        LoginPage(navController).Log('a')
    }
}

@Preview
@Composable
fun LoginPageUserPreview() {
    BillingAppTheme {
        val navController = rememberNavController()
        LoginPage(navController).Log('u')
    }
}
