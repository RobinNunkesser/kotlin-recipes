package de.hshl.isd.settings

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.preference.PreferenceManager
import androidx.preference.PreferenceManager.getDefaultSharedPreferences
import de.hshl.isd.settings.ui.theme.SettingsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SettingsTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    val prefs = getDefaultSharedPreferences(LocalContext.current)
    var test by remember { mutableStateOf(prefs.getString("zipCode", "World")!!) }
    Column() {
        TextField(value = test, onValueChange = {
            test = it
            prefs.edit().putString("zipCode",it).apply()
        })
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SettingsTheme {
        MainContent()
    }
}