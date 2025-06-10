package com.example.animewiki.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.animewiki.navigation.Screens

fun NavGraphBuilder.searchComposable(
    navController: NavHostController
) {
    composable<Screens.Search> { navBackStackEntry ->

    }
}