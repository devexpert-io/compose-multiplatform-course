package io.devexpert.cmpcourse.screen.home

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage

@Composable
fun Home(viewModel: HomeViewModel = viewModel()) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        contentPadding = WindowInsets.statusBars.asPaddingValues()
    ) {
        itemsIndexed(viewModel.state, key = { _, item -> item.id }) { index, item ->
            ListItem(
                headlineContent = { Text(item.title) },
                leadingContent = {
                    AsyncImage(
                        model = item.thumb,
                        contentDescription = item.title,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                    )
                },
                supportingContent = { Text(item.subtitle) },
                trailingContent = {
                    MoreActionsIconButton(
                        onActionClick = { viewModel.onAction(it, index) }
                    )
                },
                modifier = Modifier.animateItem()
            )
        }
    }
}

@Composable
fun MoreActionsIconButton(onActionClick: (Action) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    IconButton(onClick = { expanded = !expanded }) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More options"
        )
    }
    DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
        DropdownMenuItem(
            text = { Text("Clone") },
            onClick = { expanded = false; onActionClick(Action.CLONE) }
        )
        DropdownMenuItem(
            text = { Text("Delete") },
            onClick = { expanded = false; onActionClick(Action.DELETE) }
        )
    }
}