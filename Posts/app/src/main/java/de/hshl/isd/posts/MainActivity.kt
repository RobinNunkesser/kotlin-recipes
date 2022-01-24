package de.hshl.isd.posts

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.*
import de.hshl.isd.placeholderposts.core.ConcreteGetPostCommand
import de.hshl.isd.placeholderposts.core.ports.PostIDDTO
import de.hshl.isd.placeholderposts.infrastructure.adapters.PostRepositoryAdapter
import de.hshl.isd.posts.ui.theme.PostsTheme
import kotlinx.coroutines.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PostsTheme {
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
    var id by remember { mutableStateOf("1") }
    var resultText by remember { mutableStateOf("") }
    val service = ConcreteGetPostCommand(PostRepositoryAdapter())
    val scope = rememberCoroutineScope()

    fun success(value: String) {
        resultText = value
    }

    fun failure(error: Throwable) {
        Log.e(tag, error.localizedMessage!!)
    }

    Column {
        TextField(
            value = id,
            onValueChange = {
                id = it
            }
        )
        Button(onClick = {
            scope.launch {
                kotlin.runCatching {
                    service.execute(ConcretePostIDDTO(id.toLong()))
                }
                    .onSuccess(::success)
                    .onFailure(::failure)
            }
        }) {
            Text("Start")
        }
        Text(resultText)
    }
}