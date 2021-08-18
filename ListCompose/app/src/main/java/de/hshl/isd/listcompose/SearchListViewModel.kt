package de.hshl.isd.listcompose

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class SearchListViewModel : ViewModel() {
    var filter by mutableStateOf("")
    var items by mutableStateOf(listOf<ItemViewModel>())
        private set
    var filteredItems: List<ItemViewModel> = listOf()
        get() {
            if (filter.isNullOrBlank()) return items
            return items.filter {
                it.title.contains(
                    filter,
                    ignoreCase = true
                ) || it.subtitle.contains(filter, ignoreCase = true)
            }
        }
    
    fun replaceItems(newitems: List<ItemViewModel>) {
        items = newitems
    }

}