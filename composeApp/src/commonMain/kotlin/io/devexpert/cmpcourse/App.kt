package io.devexpert.cmpcourse

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import io.devexpert.cmpcourse.screens.detail.Detail
import io.devexpert.cmpcourse.screens.detail.DetailViewModel
import io.devexpert.cmpcourse.screens.home.Home
import io.devexpert.cmpcourse.screens.login.Login
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        val navController = rememberNavController()
        NavHost(navController, startDestination = Home) {
            composable<Login> {
                Login(onLoggedIn = { navController.navigate(Home) })
            }

            composable<Home> {
                Home(onItemClick = { navController.navigate(Detail(it.id)) })
            }

            composable<Detail> { backStackEntry ->
                val detail = backStackEntry.toRoute<Detail>()
                Detail(
                    viewModel = viewModel { DetailViewModel(detail.id) },
                    onBack = { navController.popBackStack() }
                )
            }
        }
    }
}