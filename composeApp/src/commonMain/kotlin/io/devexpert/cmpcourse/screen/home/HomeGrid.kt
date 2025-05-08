package io.devexpert.cmpcourse.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import io.devexpert.cmpcourse.data.Item

@Composable
fun HomeGrid(items: List<Item>, onActionClick: (Action, Int) -> Unit, modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(180.dp),
        modifier = modifier.fillMaxSize()
    ) {
        itemsIndexed(items, key = { _, item -> item.id }) { index, item ->
            Column(
                modifier = Modifier
                    .padding(2.dp)
                    .animateItem()
            ) {
                AsyncImage(
                    model = item.thumb,
                    contentDescription = item.title,
                    modifier = Modifier.aspectRatio(1f)
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = item.title,
                        modifier = Modifier
                            .weight(1f)
                            .padding(start = 8.dp)
                    )
                    MoreActionsIconButton(
                        onActionClick = { onActionClick(it, index) }
                    )
                }
            }
        }
    }
}