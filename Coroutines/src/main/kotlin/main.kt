import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

fun main() = Window {
    var text by remember { mutableStateOf("") }
    val asyncExample = AsyncExample()

    MaterialTheme {
        Column {
            Button(onClick = {
                asyncExample.backgroundExample()
            }) {
                Text("Background example")
            }
            Button(onClick = {
                asyncExample.uiExample {
                    text = it
                }
            }) {
                Text("UI example")
            }
            Text(text)
        }
    }
}