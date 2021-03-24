package de.hshl.isd.ultimateanswer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import de.hshl.isd.core.ConcreteGetAnswerCommand
import de.hshl.isd.infrastructure.adapters.SuperComputerAdapter
import de.hshl.isd.ultimateanswer.ui.theme.UltimateAnswerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UltimateAnswerTheme {
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
    var question by remember { mutableStateOf("") }
    var resultText by remember { mutableStateOf("") }
    var service = ConcreteGetAnswerCommand(SuperComputerAdapter())


    fun success(value: String) {
        resultText = value
    }

    fun failure(error: Throwable) {
        Log.e(tag, error.localizedMessage!!)
    }

    Column {
        TextField(
            value = question,
            onValueChange = {
                question = it
            }
        )
        Button(onClick = {
            service.execute(question, ::success, ::failure)
        }) {
            Text("Start")
        }
        Text(resultText)
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    UltimateAnswerTheme {
        MainContent()
    }
}