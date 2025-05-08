package io.devexpert.cmpcourse.screens.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import io.devexpert.cmpcourse.data.Item
import io.devexpert.cmpcourse.data.itemList

class DetailViewModel(private val itemId: Int) : ViewModel() {

    var state by mutableStateOf<Item?>(null)
        private set

    init {
        state = itemList.find { it.id == itemId }
    }
}