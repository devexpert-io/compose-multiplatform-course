package io.devexpert.cmpcourse

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import io.devexpert.cmpcourse.screen.home.Home
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        Home()
    }
}