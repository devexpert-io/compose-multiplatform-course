package io.devexpert.cmpcourse.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.devexpert.cmpcourse.data.itemList

@Composable
fun Home() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = WindowInsets.statusBars.asPaddingValues()
    ) {
        items(itemList, key = { it.id }) { item ->
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(item.title)
                Text(item.subtitle)
            }
        }
    }
}