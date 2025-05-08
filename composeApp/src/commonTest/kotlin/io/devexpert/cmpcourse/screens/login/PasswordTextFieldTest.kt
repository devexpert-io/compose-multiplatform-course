package io.devexpert.cmpcourse.screens.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.test.ExperimentalTestApi
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.runComposeUiTest
import kotlin.test.Test

@OptIn(ExperimentalTestApi::class)
class PasswordTextFieldTest {

    @Test
    fun revealIconShowsPassword() = runComposeUiTest {
        setContent {
            var pass by remember { mutableStateOf("") }
            PasswordTextField(
                value = pass,
                onValueChange = { pass = it },
                onDone = {}
            )
        }

        onNodeWithText("").performTextInput("1234")
        onNodeWithText("••••").assertExists()

        onNodeWithContentDescription("Show password").performClick()
        onNodeWithText("1234").assertExists()
    }
}