package de.hshl.isd.asynccompose

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import de.hshl.isd.asynccompose.ui.theme.AsyncComposeTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

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
    val tag = "MainContent"
    var resultText by remember { mutableStateOf("") }
    val asyncExample = AsyncExample()
    val scope = rememberCoroutineScope()

    Column {
        Button(onClick = {
            // launch a new coroutine in background and continue
            scope.launch {
                delay(1000L) // non-blocking delay for 1 second
                Log.d(tag,"World!") // log after delay
            }
            Log.d(tag,"Hello,") // thread continues while coroutine is delayed
        }) {
            Text("Background example")
        }
        Button(onClick = {
            scope.launch {
                kotlin.runCatching { asyncExample.asyncCalculation() }
                    .onSuccess { resultText = it.toString() }
                    .onFailure { Log.e(tag, it.localizedMessage, it) }
            }
        }) {
            Text("UI example")
        }
        Button(onClick = {
            scope.launch {
                kotlin.runCatching { asyncExample.readFromNetwork() }
                    .onSuccess { resultText = it.toString() }
                    .onFailure { Log.e(tag, it.localizedMessage, it) }
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