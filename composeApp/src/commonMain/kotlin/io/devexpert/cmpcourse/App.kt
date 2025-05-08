package io.devexpert.cmpcourse

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.devexpert.cmpcourse.screens.home.Home
import io.devexpert.cmpcourse.screens.login.Login
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(navController, startDestination = Login) {
            composable<Login> {
                Login(onLoggedIn = { navController.navigate(Home) })
            }

            composable<Home> { Home() }
        }
    }
}