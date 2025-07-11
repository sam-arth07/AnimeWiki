package com.example.animewiki.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.animewiki.navigation.Screens
import com.example.animewiki.presentation.screens.home.HomeScreen

fun NavGraphBuilder.homeComposable(
    navController: NavHostController
) {
    composable<Screens.Home> { navBackStackEntry ->
        HomeScreen(
            navController = navController
        )
    }
}