package de.hshl.isd.listcompose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun StaticList() {
    LazyColumn {
        item { Text("Item 1") }
        item { Text("Item 2") }
        item { Text("Item 3") }
    }
}
