package de.hshl.isd.navigation

enum class ScreenName { HOME, DASHBOARD, SECONDLEVEL }

sealed class Screen(val id: ScreenName) {
    object Home : Screen(ScreenName.HOME)
    object Dashboard : Screen(ScreenName.DASHBOARD)
    data class SecondLevel(val message: String) : Screen(ScreenName.SECONDLEVEL)
}
