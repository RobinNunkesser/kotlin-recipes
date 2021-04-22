package de.hshl.isd.bottomnavigationrecipe

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController

@Composable
fun Main() {
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
        NavigationHost(navController)
    }
}