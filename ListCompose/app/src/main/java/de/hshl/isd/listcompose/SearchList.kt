package de.hshl.isd.listcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SearchList(
    viewModel: SearchListViewModel,
    listitems: List<ItemViewModel>
) {

    viewModel.replaceItems(listitems)
    Column {
        TextField(value = viewModel.filter,
            modifier = Modifier.padding(8.dp),
            onValueChange = {
                viewModel.filter = it
            })
        LazyColumn {
            items(viewModel.filteredItems) {
                ItemRow(it)
            }
        }
    }
}