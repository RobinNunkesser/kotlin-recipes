package de.hshl.isd.bottomnavigationrecipe

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int? = null,
    val icon: ImageVector? = null
) {
    object Home : Screen("home", R.string.nav_item_home, Icons.Filled.Home)
    object Dashboard :
        Screen("dashboard", R.string.nav_item_dashboard, Icons.Filled.List)

    object SecondLevel : Screen("secondlevel")
}

@Composable
fun NavigationHost(
    navController: NavHostController,
    startDestination: String = Screen.Home.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screen.Home.route) {
            Home(navController = navController)
        }
        composable(Screen.Dashboard.route) {
            Dashboard(navController = navController)
        }
        composable(Screen.SecondLevel.route) {
            SecondLevelScreen(message = "Hello second level")
        }
    }
}