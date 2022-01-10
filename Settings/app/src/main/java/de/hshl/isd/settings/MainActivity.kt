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
    val key = "preference_key"
    val defaultValue = "Default Value"
    var test by remember { mutableStateOf(prefs.getString(key, defaultValue)!!) }
    Column() {
        TextField(value = test, onValueChange = {
            test = it
            prefs.edit().putString(key,it).apply()
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