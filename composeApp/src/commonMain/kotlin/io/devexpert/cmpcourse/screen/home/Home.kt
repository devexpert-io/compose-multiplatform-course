package io.devexpert.cmpcourse.screen.home

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Home(viewModel: HomeViewModel = viewModel()) {
    HomeGrid(
        items = viewModel.state,
        onActionClick = viewModel::onAction
    )
}

@Composable
fun MoreActionsIconButton(onActionClick: (Action) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    IconButton(onClick = { expanded = !expanded }) {
        Icon(
            imageVector = Icons.Default.MoreVert,
            contentDescription = "More options"
        )
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
}