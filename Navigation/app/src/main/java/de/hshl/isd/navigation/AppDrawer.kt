package de.hshl.isd.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun AppDrawer(
    navigateTo: (Screen) -> Unit,
    currentScreen: Screen,
    closeDrawer: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize()) {
        DrawerButton(
            icon = Icons.Filled.Home,
            label = "Home",
            isSelected = currentScreen == Screen.Home,
            action = {
                navigateTo(Screen.Home)
                closeDrawer()
            }
        )
        DrawerButton(
            icon = Icons.Filled.List,
            label = "Dashboard",
            isSelected = currentScreen == Screen.Dashboard,
            action = {
                navigateTo(Screen.Dashboard)
                closeDrawer()
            }
        )
    }
}