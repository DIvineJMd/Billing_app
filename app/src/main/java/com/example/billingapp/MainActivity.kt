package com.example.billingapp
import LoginPage
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.google.firebase.FirebaseApp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    private val googleAuthUiclient by lazy {
        LoginPage(
            context = applicationContext,
            oneTapClient = com.google.android.gms.auth.api.identity.Identity.getSignInClient(applicationContext)
        )
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        setContent {

            val navController = rememberNavController()
            NavHost(navController, startDestination = "splash") {
                composable("splash") { SplashScreen(navController) }
                composable("login"){
                    val viewModel = viewModel<SigninViewmodel>()
                    val state by viewModel.state.collectAsState()
                    val launcher= rememberLauncherForActivityResult(
                        contract = ActivityResultContracts.StartIntentSenderForResult( ),
                        onResult = {result->
                            if(result.resultCode== RESULT_OK){
                                lifecycleScope.launch {
                                    val signInResult=googleAuthUiclient.getSignInIntent(
                                        intent=result.data?:return@launch
                                    )
                                    viewModel.onSignInResult(signInResult)
                                }
                            }
                        }
                    )
                    LaunchedEffect(key1 = state.isSignInSuccessfully ){
                        if(state.isSignInSuccessfully){
                            Toast.makeText(
                                applicationContext,
                                "signsuccesfull",
                                Toast.LENGTH_LONG

                            ).show()
                        }
                    }

                    Log(
                        state = state,
                        onSignInCIick = {
                            lifecycleScope.launch {
                                val signInIntentSender = googleAuthUiclient.signln()
                                        launcher.launch(
                                            IntentSenderRequest.Builder(
                                            signInIntentSender?:return@launch
                                        ).build())


                            }
                        }
                    )
                }
//                composable("userPage") { LoginPage(navController).Log() }
//                composable("home"){Home(navController).NavDra(Modifier)}
//                composable("inv"){Inventory().Iventory()}
//                composable("rep"){Reports().report()}
//                composable("lon"){Loan().loan()}
//                composable("sellp"){Sellpage().sell()}
//                composable("pro"){ProfileP().MyProfile()}
            }
            }
        }
    }


@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(true) {
        delay(3000) // Delay for 3 seconds
        navController.navigate("login") // Navigate to the login page
    }

    SatguruTelecomText()
}

@Composable
fun SatguruTelecomText() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
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

        Text(
            text = "\n" +
                    "App developed by APA",
            style = TextStyle(fontSize = 15.sp, color = Color.Black)
        )
    }
}



@Preview
@Composable
fun SatguruTelecomTextPreview() {
    SatguruTelecomText()
}
