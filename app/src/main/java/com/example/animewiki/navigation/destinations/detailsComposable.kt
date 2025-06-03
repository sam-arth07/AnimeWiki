package com.example.animewiki.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.example.animewiki.navigation.Screens

fun NavGraphBuilder.detailsComposable() {
    composable<Screens.Details> {navBackStackEntry ->
        val heroId = navBackStackEntry.toRoute<Screens.Details>().heroId

    }
}