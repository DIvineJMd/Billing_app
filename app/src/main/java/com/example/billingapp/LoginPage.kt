
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.billingapp.ui.theme.BillingAppTheme


class LoginPage {
    @Composable
    fun content() {
        // Implement your login screen UI here
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = { /* Handle button click action here */ },
                modifier = Modifier
                    .padding(10.dp)
                    .height(50.dp)
                    .width(500.dp),
                colors = ButtonDefaults.buttonColors(
                    Color(0xFFFF6B00)
                ),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text(text = "Login as Admin",
                    style = TextStyle(
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White
                    )
                )
            }

            Spacer(modifier = Modifier.height(16.dp)) // Adjust the height as needed

            Button(
                onClick = { /* Handle button click action here */ },
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
}


@Preview
    (showBackground = true,
    wallpaper = Wallpapers.YELLOW_DOMINATED_EXAMPLE)
@Composable
fun LoginPagePreview() {
    BillingAppTheme {
        LoginPage().content()
    }
}
