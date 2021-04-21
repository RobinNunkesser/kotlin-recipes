package de.hshl.isd.bottomnavigationrecipe

import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import de.hshl.isd.bottomnavigationrecipe.ui.theme.BottomNavigationRecipeTheme

@Composable
fun Home(navController: NavController) {
    BottomNavigationRecipeTheme {
        Scaffold {
            Button(onClick = { //navController.navigate(MainDestinations.DETAIL_ROUTE)
            }) {
                Text(text = "Navigate deeper")
            }
        }
    }
}

