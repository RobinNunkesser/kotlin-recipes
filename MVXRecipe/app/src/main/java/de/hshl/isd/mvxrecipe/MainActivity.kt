package de.hshl.isd.mvxrecipe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import de.hshl.isd.mvxrecipe.ui.theme.MVXRecipeTheme

class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVXRecipeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainContent(viewModel)
                }
            }
        }
    }
}

@Composable
fun MainContent(viewModel: MainViewModel) {

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "MVU") })
        },
        content = {
            Column(verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp)) {
                TextField(value = viewModel.forename,
                    onValueChange = {
                        viewModel.forename = it
                    })
                TextField(value = viewModel.surname,
                    onValueChange = {
                        viewModel.surname = it
                    })
                Row {
                    Text(text = "Forename")
                    Text(
                        text = viewModel.forename
                    )
                }
                Row {
                    Text(text = "Surname")
                    Text(
                        text = viewModel.surname
                    )
                }
                Button(onClick = { viewModel.reset() }) {
                    Text("Reset")
                }
            }
        })
}
