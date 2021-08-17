package de.hshl.isd.basicnavigation

import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun Home(navController: NavController) {
    Button(onClick = { navController.navigate(Screen.Detail.route) }) {
        Text(text = "Navigate deeper")
    }
}

