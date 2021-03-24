package de.hshl.isd.listcompose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable

@Composable
fun SectionedList(sections: Map<String, List<ItemViewModel>>) {
    LazyColumn {
        items(sections.keys.toList()) { sectionTitle ->
            SectionHeader(title = sectionTitle)
            sections[sectionTitle]!!.forEach { item ->
                ItemRow(item = item)
            }
        }
    }
}