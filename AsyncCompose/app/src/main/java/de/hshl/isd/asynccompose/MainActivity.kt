package de.hshl.isd.asynccompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import de.hshl.isd.asynccompose.ui.theme.AsyncComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AsyncComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    var resultText by remember { mutableStateOf("") }
    val asyncExample = AsyncExample()

    Column {
        Button(onClick = {
            asyncExample.backgroundExample()
        }) {
            Text("Background example")
        }
        Button(onClick = {
            asyncExample.uiExample {
                resultText = it
            }
        }) {
            Text("UI example")
        }
        Button(onClick = {
            asyncExample.uiNetworkExample {
                resultText = it
            }
        }) {
            Text("UI with Network example")
        }
        Text(resultText)
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AsyncComposeTheme {
        MainContent()
    }
}