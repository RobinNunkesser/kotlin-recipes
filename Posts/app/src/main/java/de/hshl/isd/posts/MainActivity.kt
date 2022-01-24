package de.hshl.isd.posts

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
    var service = ConcreteGetPostCommand(PostRepositoryAdapter())


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
            MainScope().launch {
                withContext(Dispatchers.IO) {
                    val result = kotlin.runCatching {
                        service.execute(ConcretePostIDDTO(id.toLong()))
                    }
                    result.onSuccess(::success)
                    result.onFailure(::failure)
                }
            }
        }) {
            Text("Start")
        }
        Text(resultText)
    }
}