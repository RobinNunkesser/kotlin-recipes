package de.hshl.isd.basicnavigation

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import de.hshl.isd.basicnavigation.ui.theme.BasicNavigationTheme

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