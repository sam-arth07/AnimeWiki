package com.example.animewiki.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.animewiki.navigation.Screens
import com.example.animewiki.presentation.screens.splash.SplashScreen

fun NavGraphBuilder.splashComposable(navController: NavHostController) {
    composable<Screens.Splash> { navBackStackEntry ->
        SplashScreen(navController = navController)
    }
}