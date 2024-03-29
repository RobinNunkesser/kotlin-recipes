package de.hshl.isd.webviewrecipe

import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import de.hshl.isd.webviewrecipe.ui.theme.WebViewRecipeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WebViewRecipeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    CustomWebView(url = "https://www.hshl.de")
                }
            }
        }
    }
}

@Composable
fun CustomWebView(url: String) {
    Column(modifier = Modifier.fillMaxSize()) {
        AndroidView<WebView>(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                val myWebView = WebView(context)
                myWebView.loadUrl(url)
                myWebView.apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT,
                    )
                }
            })
    }
}