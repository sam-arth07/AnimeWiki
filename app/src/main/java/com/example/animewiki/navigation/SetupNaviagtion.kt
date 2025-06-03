package com.example.animewiki.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.example.animewiki.navigation.destinations.detailsComposable
import com.example.animewiki.navigation.destinations.homeComposable
import com.example.animewiki.navigation.destinations.searchComposable
import com.example.animewiki.navigation.destinations.splashComposable
import com.example.animewiki.navigation.destinations.welcomeComposable

@Composable
fun SetupNavigation(
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = Screens.Splash
    ) {
        splashComposable()
        welcomeComposable()
        homeComposable()
        searchComposable()
        detailsComposable()
    }
}