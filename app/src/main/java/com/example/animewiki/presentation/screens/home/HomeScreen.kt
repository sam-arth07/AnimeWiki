package com.example.animewiki.presentation.screens.home

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.toColorInt
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.animewiki.navigation.Screens
import com.example.animewiki.presentation.common.ListContent
import com.example.animewiki.ui.theme.topAppBarBackgroundColor
import com.example.animewiki.ui.theme.welcomeScreenBackgroundColor

@Composable
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "ContextCastToActivity")
fun HomeScreen(
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    val activity = LocalContext.current as Activity
    val statusBarColor = MaterialTheme.colorScheme.topAppBarBackgroundColor

    SideEffect {
        activity.window.statusBarColor = statusBarColor.toArgb()
    }

    val heroes = homeViewModel.getAllHeroes.collectAsLazyPagingItems()
    Scaffold(
        topBar = {
            HomeTopBar(onSearchClicked = {
                navController.navigate(Screens.Search)
            })
        },
        content = { paddingValues ->
            ListContent(
                modifier = Modifier.padding(
                    top = paddingValues.calculateTopPadding(),
                    bottom = paddingValues.calculateBottomPadding()
                ),
                navController = navController,
                heroes = heroes
            )
        })
}
