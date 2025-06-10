package com.example.animewiki.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.animewiki.navigation.Screens
import com.example.animewiki.presentation.screens.welcome.WelcomeScreen

fun NavGraphBuilder.welcomeComposable(
    navController: NavHostController
) {
    composable<Screens.Welcome> { navBackStackEntry ->
        WelcomeScreen(navController = navController)
    }
}