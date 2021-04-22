package de.hshl.isd.basicnavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import de.hshl.isd.basicnavigation.ui.theme.BasicNavigationTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainContent()
        }
    }
}

@Composable
fun MainContent() {
    val navController = rememberNavController()

    BasicNavigationTheme {
        Scaffold(
            topBar = {
                TopAppBar {
                    Text(text = "Basic Navigation")
                }
            }
        ) {
            NavigationHost(navController)
        }
    }
}