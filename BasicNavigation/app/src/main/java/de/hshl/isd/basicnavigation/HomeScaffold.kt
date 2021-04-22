package de.hshl.isd.basicnavigation

import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import de.hshl.isd.basicnavigation.ui.theme.BasicNavigationTheme

@Composable
fun Home(navController: NavController) {
    BasicNavigationTheme {
        Scaffold {
            Button(onClick = { navController.navigate(Screen.Detail.route) }) {
                Text(text = "Navigate deeper")
            }
        }
    }
}

