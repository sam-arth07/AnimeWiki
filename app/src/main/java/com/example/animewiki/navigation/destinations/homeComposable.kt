package com.example.animewiki.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.animewiki.navigation.Screens
import com.example.animewiki.ui.screens.home.HomeScreen

fun NavGraphBuilder.homeComposable() {
    composable<Screens.Home> { navBackStackEntry ->
        HomeScreen()
    }
}