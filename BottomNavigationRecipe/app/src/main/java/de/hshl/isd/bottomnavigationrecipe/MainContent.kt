package de.hshl.isd.bottomnavigationrecipe

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import de.hshl.isd.bottomnavigationrecipe.ui.theme.BottomNavigationRecipeTheme

@Composable
fun MainContent() {
    val navController = rememberNavController()

    BottomNavigationRecipeTheme {
        Scaffold(
            topBar = {
                TopAppBar(title = {
                    Text(text = "Bottom Navigation")
                })
            },
            bottomBar = { BottomBar(navController) }
        ) {
            NavigationHost(navController)
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val items = listOf(
        Screen.Home,
        Screen.Dashboard,
    )

    BottomNavigation {
        val navBackStackEntry by
        navController.currentBackStackEntryAsState()
        val currentDestination =
            navBackStackEntry?.destination
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon!!,
                        contentDescription = stringResource(screen.resourceId!!)
                    )
                },
                label = { Text(stringResource(screen.resourceId!!)) },
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}