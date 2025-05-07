package io.devexpert.cmpcourse.screen.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.devexpert.cmpcourse.data.itemList

enum class Action { CLONE, DELETE }

class HomeViewModel : ViewModel() {

    var state by mutableStateOf(itemList)
        private set

    private var nextKey = state.size

    fun onAction(action: Action, index: Int) {
        state = state.toMutableList().apply {
            when (action) {
                Action.CLONE -> {
                    add(index, get(index).copy(id = nextKey++))
                }
                Action.DELETE -> removeAt(index)
            }
        }
    }
}