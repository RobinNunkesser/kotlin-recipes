package de.hshl.isd.machinetranslate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import de.hshl.isd.machinetranslate.ui.theme.MachineTranslateTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MachineTranslateTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainContent(viewModel)
                }
            }
        }
    }
}

@Composable
fun MainContent(viewModel: MainViewModel) {
    Column(verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(8.dp)) {
        TextField(viewModel.sourceText,
            onValueChange = {
                viewModel.sourceText = it
                viewModel.translate()
            })


            Text(
                text = viewModel.translatedText
            )

        }


}

