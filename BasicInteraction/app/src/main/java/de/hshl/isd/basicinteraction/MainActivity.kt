package de.hshl.isd.basicinteraction

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.hshl.isd.basicinteraction.ui.theme.BasicInteractionTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BasicInteractionTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainContent()
                }
            }
        }
    }
}

@Composable
fun MainContent() {
    var input by rememberSaveable { mutableStateOf("Test") }
    var output by rememberSaveable { mutableStateOf("") }
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
                    value = input,
                    onValueChange = {
                        input = it
                    }
                )
                Button(
                    onClick = {
                        output = input.toUpperCase()
                    }
                ) {
                    Text("Process")
                }
                Text(text = output)
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