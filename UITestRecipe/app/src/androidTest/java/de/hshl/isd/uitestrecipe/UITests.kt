package de.hshl.isd.uitestrecipe

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.ComposeContentTestRule
import androidx.compose.ui.test.junit4.ComposeTestRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.filters.MediumTest
import de.hshl.isd.uitestrecipe.ui.theme.UITestRecipeTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

fun ComposeContentTestRule.setMaterialContent(children: @Composable() () -> Unit) {
    setContent {
        UITestRecipeTheme {
            Surface {
                children()
            }
        }
    }
}


@MediumTest
@RunWith(JUnit4::class)
class UITests {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
        composeTestRule.setMaterialContent { Greeting(name = "Android") }
    }

    @Test
    fun greetingIsDisplayed() {
        composeTestRule.onNodeWithText("Hello Android!").assertIsDisplayed()
    }
}