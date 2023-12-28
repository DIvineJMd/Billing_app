package com.example.billingapp

import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.IntentSenderRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.billingapp.functions.ProfileP
import com.example.billingapp.home.Home2
import com.example.billingapp.signin.GoogleAuthUiClient
import com.example.billingapp.signin.SignInScreen
import com.example.billingapp.signin.SignInViewModel
import com.example.billingapp.ui.theme.SataguruTelecomTheme
import com.example.billingapp.ui.theme.Setcolorbar
import com.example.billingapp.workspace.Inventory
import com.example.billingapp.workspace.accessories.Addass
import com.example.billingapp.workspace.accessories.Ass
import com.example.billingapp.workspace.accessories.Asslist
import com.example.billingapp.workspace.mobile.AddEditphone
import com.example.billingapp.workspace.mobile.InventoryViewModel
import com.example.billingapp.workspace.mobile.MobileListContent
import com.example.billingapp.workspace.mobile.MobilelistViewModel
import com.example.billingapp.workspace.mobile.PhoneInventory
import com.google.android.gms.auth.api.identity.Identity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch



class MainActivity : ComponentActivity() {

    private val googleAuthUiClient by lazy {
        GoogleAuthUiClient(
            context = applicationContext,
            oneTapClient = Identity.getSignInClient(applicationContext)
        )
    }
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SataguruTelecomTheme {
                Setcolorbar().SetStatusBarColor(color = MaterialTheme.colorScheme.background)// A surface container using the 'background' color from the theme
                androidx.compose.material.Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = androidx.compose.material.MaterialTheme.colors.background
                ) {
                    val assViewModel: Ass.AccessoriesViewModel = viewModel()
                    val mobileViewModel : MobilelistViewModel= viewModel()
                    val navController = rememberNavController()
                    NavHost(navController, startDestination = "splash"){
                        composable("splash") { SplashScreen(navController) }
                        composable("Profile"){ProfileP(navController).MyProfile(userData = googleAuthUiClient.getSignedInUser())}
                        composable("phone/{phoneName}") { navBackStackEntry ->
                            val phoneName = navBackStackEntry.arguments?.getString("phoneName") ?: ""
                            PhoneInventory(phoneName,navController)
                        }
                        composable("accessories/{categoryName}") { navBackStackEntry ->
                            val categoryName = navBackStackEntry.arguments?.getString("categoryName") ?: ""
                            Ass().AccessoriesInventory(categoryName, navController)
                        }

                        composable("ass"){Asslist().AssListContent(navController = navController)}
                        composable("addass"){ Addass(navController = navController,assViewModel) }

                        composable("mobilelist"){ MobileListContent(mobileViewModel, navController = navController)}
                        composable("addm"){AddEditphone().AddEditPhoneContent(viewModel = mobileViewModel,navController,false,"","")}
                        composable("editm/{company}/{phonename}") { backStackEntry ->
                            val company = backStackEntry.arguments?.getString("company") ?: ""
                            val phoneName = backStackEntry.arguments?.getString("phonename") ?: ""

                            AddEditphone().AddEditPhoneContent(
                                viewModel = mobileViewModel,
                                navController = navController,
                                Editmode = true,
                                com = company,
                                ph = phoneName
                            )
                        }

                        composable("inv"){Inventory(navController).Inventory()}
                        composable("sign_in") {
                            val viewModel = viewModel<SignInViewModel>()
                            val state by viewModel.state.collectAsStateWithLifecycle()

                            LaunchedEffect(key1 = Unit) {
                                if (googleAuthUiClient.getSignedInUser() != null) {
                                    navController.navigate("Home")
                                }
                            }

                            val launcher = rememberLauncherForActivityResult(
                                contract = ActivityResultContracts.StartIntentSenderForResult(),
                                onResult = { result ->
                                    if (result.resultCode == RESULT_OK) {
                                        lifecycleScope.launch {
                                            val signInResult = googleAuthUiClient.signInWithIntent(
                                                intent = result.data ?: return@launch
                                            )
                                            viewModel.onSignInResult(signInResult)
                                        }
                                    }
                                }
                            )

                            LaunchedEffect(key1 = state.isSignInSuccessful) {
                                if (state.isSignInSuccessful) {
                                    Toast.makeText(
                                        applicationContext,
                                        "Sign in successful",
                                        Toast.LENGTH_LONG
                                    ).show()

                                    navController.navigate("Home")
                                    viewModel.resetState()
                                }
                            }

                            SignInScreen(
                                state = state,
                                onSignInClick = {
                                    lifecycleScope.launch {
                                        val signInIntentSender = googleAuthUiClient.signIn()
                                        launcher.launch(
                                            IntentSenderRequest.Builder(
                                                signInIntentSender ?: return@launch
                                            ).build()
                                        )
                                    }
                                }
                            )
                        }
                        composable("Home") {
                            Home2(navController).NavDra(
                                Modifier,
                                userData = googleAuthUiClient.getSignedInUser(),
                                onSignOut = {
                                    lifecycleScope.launch {
                                        googleAuthUiClient.signOut()
                                        Toast.makeText(
                                            applicationContext,
                                            "Signed out",
                                            Toast.LENGTH_LONG
                                        ).show()

                                        navController.popBackStack()
                                    }
                                }

                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SplashScreen(navController: NavHostController) {
    LaunchedEffect(true) {
        delay(1000) // Delay for 3 seconds
        navController.navigate("sign_in") // Navigate to the login page
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
