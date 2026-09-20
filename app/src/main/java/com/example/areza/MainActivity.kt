package com.example.areza

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.areza.ui.screen.HubungiKamiScreen
import com.example.areza.ui.theme.JualanTheme
import com.example.areza.ui.theme.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.areza.ui.screen.BasicInfoScreen
import com.example.areza.ui.screen.DaftarProductScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JualanTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = "product_list"
                    ) {
                        composable(route = "product_list") {
                            DaftarProductScreen(
                                onNavigateToContact = {
                                    navController.navigate(route = "form_screen")
                                }
                            )
                        }
                        composable(route = "basic_info") {
                            BasicInfoScreen(
                                onNavigateToContact = {
                                    navController.navigate(route = "form_screen")
                                }
                            )
                        }
                        composable(route = "form_screen") {
                            HubungiKamiScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JualanTheme {
        Greeting("Android")
    }
}