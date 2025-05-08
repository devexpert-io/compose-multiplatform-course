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
import composemultiplatformcourse.composeapp.generated.resources.Res
import composemultiplatformcourse.composeapp.generated.resources.clone
import composemultiplatformcourse.composeapp.generated.resources.delete
import composemultiplatformcourse.composeapp.generated.resources.more_options
import org.jetbrains.compose.resources.stringResource

@Composable
fun Home(viewModel: HomeViewModel = viewModel { HomeViewModel() }) {
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
            contentDescription = stringResource(Res.string.more_options)
        )
        DropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            DropdownMenuItem(
                text = { Text(stringResource(Res.string.clone)) },
                onClick = { expanded = false; onActionClick(Action.CLONE) }
            )
            DropdownMenuItem(
                text = { Text(stringResource(Res.string.delete)) },
                onClick = { expanded = false; onActionClick(Action.DELETE) }
            )
        }
    }
}