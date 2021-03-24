package de.hshl.isd.listcompose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun SimpleList(listitems: List<ItemViewModel>) {
    LazyColumn {
        items(listitems) {
                item -> ItemRow(item)}
    }
}

