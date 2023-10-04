
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
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
            Text(
                text = "Login Screen",
                style = TextStyle(fontSize = 28.sp, color = Color.Black)
            )

            // Add a Button with custom background color
            Button(
                onClick = {
                    // Handle button click action here
                    // For example, you can navigate to another screen
                },
                modifier = Modifier.padding(16.dp),

            ) {
                Text(text = "Login")
            }
        }
    }
}

@Preview
@Composable
fun LoginPagePreview() {
    BillingAppTheme {
        LoginPage().content()
    }
}
