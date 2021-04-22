package de.hshl.isd.basicnavigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

object MainDestinations {
    const val HOME_ROUTE = "home"
    const val DETAIL_ROUTE = "detail"
}

@Composable
fun NavigationHost(navController: NavHostController,
                   startDestination: String = MainDestinations.HOME_ROUTE) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainDestinations.HOME_ROUTE) {
            Home(navController = navController)
        }
        composable(MainDestinations.DETAIL_ROUTE) {
            Detail(navController = navController)
        }
    }
}