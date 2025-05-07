package io.devexpert.cmpcourse.screens.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Login(viewModel: LoginViewModel = viewModel()) {
    val state = viewModel.state
    val message = when {
        state.loggedIn -> "Success"
        state.error != null -> state.error
        else -> null
    }

    var user by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically)
    ) {
        OutlinedTextField(
            value = user,
            onValueChange = { user = it }
        )
        OutlinedTextField(
            value = pass,
            onValueChange = { pass = it }
        )
        Button(
            onClick = { viewModel.login(user, pass) },
            enabled = user.isNotEmpty() && pass.isNotEmpty()
        ) {
            Text("Login")
        }
        if (message != null) {
            Text(message)
        }
    }
}