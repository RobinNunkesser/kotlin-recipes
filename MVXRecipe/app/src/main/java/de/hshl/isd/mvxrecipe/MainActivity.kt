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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.hshl.isd.mvxrecipe.ui.theme.MVXRecipeTheme

class MainActivity : ComponentActivity() {
    val viewModel by viewModels<MainViewModel>()

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

    val forename by viewModel.forename.observeAsState

    Scaffold(
        topBar = {
            TopAppBar(title = { Text(text = "MVU") })
        },
        content = {
            Column(verticalArrangement = Arrangement.Center,
                modifier = Modifier.padding(8.dp)) {
                TextField(value = viewModel.forename.value!!,
                    onValueChange = {
                        viewModel.forename.value = it
                    })
                TextField(value = viewModel.surname.value!!,
                    onValueChange = {
                        viewModel.surname.value = it
                    })
                Row {
                    Text(text = "Forename")
                    Text(
                        text = viewModel.forename.value!!
                    )
                }
                Row {
                    Text(text = "Surname")
                    Text(
                        text = viewModel.surname.value!!
                    )
                }
                Row {
                    Text(text = "Complete Name")
                    viewModel.mediatorName.value?.let { name ->
                        Text(
                            text = name,
                        )
                    }
                }
                Button(onClick = { viewModel.computeName() }) {
                    Text("Compute name")
                }
                Text(
                    text = viewModel.name.value!!
                )
            }
        })
}
