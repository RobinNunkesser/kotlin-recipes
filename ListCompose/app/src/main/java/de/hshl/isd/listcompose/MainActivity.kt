package de.hshl.isd.listcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import de.hshl.isd.listcompose.ui.theme.ListComposeTheme


class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<SearchListViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ListComposeTheme {
                Surface(color = MaterialTheme.colors.background) {
                    MainContent(viewModel)
                }
            }
        }
    }
}

@Composable
fun MainContent(viewModel: SearchListViewModel) {
    val dummyItems = listOf(
        ItemViewModel("Teddy bear", "Subtitle 1"),
        ItemViewModel("Banana", "Subtitle 2"),
        ItemViewModel("Sponge", "Subtitle 3"),
        ItemViewModel("Laptop", "Subtitle 4")
    )

    val dummySections = mapOf(
        "Section 1" to dummyItems,
        "Section 2" to listOf(ItemViewModel("Lorem Ipsum in Section 2", "Some sub"))
    )

    val currentSection = Sections.SearchList

    Column {
        TopAppBar(
            title = { Text("Interests") }
        )
        Box(modifier = Modifier.weight(1f)) {
            when (currentSection) {
                Sections.StaticList -> StaticList()
                Sections.SimpleList -> SimpleList(listitems = dummyItems)
                Sections.SectionedList -> SectionedList(sections = dummySections)
                Sections.SearchList -> SearchList(viewModel, dummyItems)
            }
        }
    }
}