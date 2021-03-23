package de.hshl.isd.basicinteraction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.hshl.isd.basicinteraction.ui.theme.BasicInteractionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicInteractionTheme {
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
    var input = remember { mutableStateOf("Test") }
    var output = remember { mutableStateOf("") }
    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "Basic Interaction") })
        },
        content = {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp)
            ) {
                TextField(
                    value = input.value,
                    onValueChange = {
                        input.value = it.toString()
                    }
                )
                Button(
                    onClick = {
                        output.value = input.value.toUpperCase()
                    }
                ) {
                    Text("Process")
                }
                Text(text = output.value)
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BasicInteractionTheme {
        MainContent()
    }
}