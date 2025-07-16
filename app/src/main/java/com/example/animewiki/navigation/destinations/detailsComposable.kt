package com.example.animewiki.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.animewiki.navigation.Screens
import com.example.animewiki.presentation.screens.details.DetailsScreen

fun NavGraphBuilder.detailsComposable(
    navController: NavHostController
) {
    composable<Screens.Details> { navBackStackEntry ->
        val heroId = navBackStackEntry.toRoute<Screens.Details>().heroId
        DetailsScreen(navController = navController)
    }
}