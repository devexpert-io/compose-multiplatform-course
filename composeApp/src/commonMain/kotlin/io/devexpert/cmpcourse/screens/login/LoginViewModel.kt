package io.devexpert.cmpcourse.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    var state by mutableStateOf(UiState())
        private set

    data class UiState(
        val loggedIn: Boolean = false,
        val error: String? = null
    )

    fun login(user: String, pass: String) {
        state = when {
            !user.contains('@') -> UiState(error = "Invalid user")
            pass.length < 5 -> UiState(error = "Invalid password")
            else -> UiState(loggedIn = true)
        }
    }
}