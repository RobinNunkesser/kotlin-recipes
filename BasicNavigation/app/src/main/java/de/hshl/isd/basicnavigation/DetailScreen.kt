package de.hshl.isd.basicnavigation

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import de.hshl.isd.basicnavigation.ui.theme.BasicNavigationTheme

@Composable
fun Detail(navController: NavController) {
    BasicNavigationTheme {
        Text(text = "Detail")
    }
}

