package de.hshl.isd.bottomnavigationrecipe

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.KEY_ROUTE
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.navigate
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
        val currentRoute =
            navBackStackEntry?.arguments?.getString(KEY_ROUTE)
        items.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon!!,
                        contentDescription = stringResource(screen.resourceId!!)
                    )
                },
                label = { Text(stringResource(screen.resourceId!!)) },
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