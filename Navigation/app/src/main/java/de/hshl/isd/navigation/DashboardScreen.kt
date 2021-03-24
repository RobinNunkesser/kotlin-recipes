package de.hshl.isd.navigation

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch

@Composable
fun DashboardScreen(
    navigateTo: (Screen) -> Unit,
    scaffoldState: ScaffoldState = rememberScaffoldState()
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        scaffoldState = scaffoldState,
        drawerContent = {
            AppDrawer(
                currentScreen = Screen.Dashboard,
                closeDrawer = {
                    coroutineScope.launch { scaffoldState.drawerState.close() }
                },
                navigateTo = navigateTo
            )
        },
        topBar = {
            TopAppBar(
                title = { Text(text = "Dashboard Screen") },
                navigationIcon = {
                    IconButton(onClick = {
                        coroutineScope.launch {
                            scaffoldState.drawerState.open()
                        } }) {
                        Icon(imageVector = Icons.Filled.Menu,
                            contentDescription = "Menu")
                    }
                }
            )

        },
        content = {
            Text("Dashboard")
        }
    )
}