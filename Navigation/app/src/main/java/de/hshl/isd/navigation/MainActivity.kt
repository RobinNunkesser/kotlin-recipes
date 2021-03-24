package de.hshl.isd.navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.Crossfade
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import de.hshl.isd.navigation.ui.theme.NavigationTheme

class MainActivity : ComponentActivity() {
    private val navigationViewModel by viewModels<NavigationViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationTheme {
                Surface(color = MaterialTheme.colors.background) {
                    AppContent(navigationViewModel)
                }
            }
        }
    }
}

@Composable
fun AppContent(navigationViewModel: NavigationViewModel) {
    Crossfade(navigationViewModel.currentScreen) { screen ->
        Surface(color = MaterialTheme.colors.background) {
            when (screen) {
                is Screen.Home -> HomeScreen(
                    navigateTo = navigationViewModel::navigateTo
                )
                is Screen.Dashboard -> DashboardScreen(
                    navigateTo = navigationViewModel::navigateTo
                )
                is Screen.SecondLevel ->
                    SecondLevelScreen(
                        message = screen.message,
                        onBack = { navigationViewModel.onBack() }
                    )
            }
        }
    }
}

