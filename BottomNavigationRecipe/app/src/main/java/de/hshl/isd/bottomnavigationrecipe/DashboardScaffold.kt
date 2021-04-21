package de.hshl.isd.bottomnavigationrecipe

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import de.hshl.isd.bottomnavigationrecipe.ui.theme.BottomNavigationRecipeTheme

@Composable
fun Dashboard(navController: NavController) {
    BottomNavigationRecipeTheme {
        Scaffold {
            Text(text = "Dashboard")
        }
    }
}

