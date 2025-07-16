package com.example.animewiki.presentation.screens.search

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.animewiki.presentation.common.ListContent
import com.example.animewiki.ui.theme.topAppBarBackgroundColor
import com.example.animewiki.ui.theme.welcomeScreenBackgroundColor
import com.example.animewiki.util.LARGE_PADDING
import com.example.animewiki.util.SMALL_PADDING

@SuppressLint("ContextCastToActivity")
@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val activity = LocalContext.current as Activity
    val statusBarColor = MaterialTheme.colorScheme.topAppBarBackgroundColor

    SideEffect {
        activity.window.statusBarColor = statusBarColor.toArgb()
    }

    val searchText by searchViewModel.searchText
    val heroes = searchViewModel.searchedHeroes.collectAsLazyPagingItems()
    Scaffold(
        topBar = {
            SearchTopBar(
                text = searchText,
                onTextChange = {
                    searchViewModel.updateSearchText(it)
                },
                onSearchClicked = {
                    searchViewModel.searchHeroes(it)
                },
                onCloseClicked = {
                    navController.popBackStack()
                },
            )
        },
    ) { paddingValues ->
        ListContent(
            heroes = heroes,
            navController = navController,
            modifier = Modifier.padding(
                top = paddingValues.calculateTopPadding() + SMALL_PADDING,
                bottom = paddingValues.calculateBottomPadding()
            )
        )
    }
}