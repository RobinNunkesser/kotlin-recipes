package de.hshl.isd.bottomnavigationrecipe

import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import de.hshl.isd.bottomnavigationrecipe.ui.theme.BottomNavigationRecipeTheme

@Composable
fun Home(navController: NavController) {
    BottomNavigationRecipeTheme {
        Scaffold {
            Button(onClick = {
                navController.navigate(Screen.SecondLevel.route)
            }) {
                Text(text = "Navigate deeper")
            }
        }
    }
}

