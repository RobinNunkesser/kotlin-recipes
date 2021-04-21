package de.hshl.isd.bottomnavigationrecipe

import androidx.annotation.StringRes
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.*

sealed class Screen(
    val route: String,
    @StringRes val resourceId: Int,
    val icon: ImageVector?
) {
    object Home : Screen("home", R.string.nav_item_home, Icons.Filled.Home)
    object Dashboard :
        Screen("dashboard", R.string.nav_item_dashboard, Icons.Filled.List)
}

@Composable
fun Main(startDestination: String = Screen.Home.route) {
    val navController = rememberNavController()
    val items = listOf(
        Screen.Home,
        Screen.Dashboard,
    )

    Scaffold(
        topBar = {
            TopAppBar(title = {
                Text(text = "Bottom Navigation")
            })
        },
        bottomBar = {
            BottomNavigation {
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute =
                    navBackStackEntry?.arguments?.getString(KEY_ROUTE)
                items.forEach { screen ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = screen.icon!!,
                                contentDescription = stringResource(id = screen.resourceId)
                            )
                        },
                        label = { Text(stringResource(screen.resourceId)) },
                        selected = currentRoute == screen.route,
                        onClick = {
                            navController.navigate(screen.route) {
                                popUpTo = navController.graph.startDestination
                                launchSingleTop = true
                            }
                        }
                    )
                }
            }
        }
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
        }
    }
}