package de.hshl.isd.listcompose

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ItemRow(item: ItemViewModel) {
    Column(
        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
    ) {
        Text(
            text = item.title,
            modifier = Modifier.padding(top = 4.dp),
            style = MaterialTheme.typography.body1
        )
        Text(
            text = item.subtitle,
            modifier = Modifier.padding(top = 4.dp),
            style = MaterialTheme.typography.caption
        )
        Divider(
            Modifier.padding(top = 8.dp, bottom = 4.dp)
        )
    }
}