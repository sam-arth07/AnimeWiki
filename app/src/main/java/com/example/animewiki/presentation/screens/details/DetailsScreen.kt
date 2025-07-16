package com.example.animewiki.presentation.screens.details

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.animewiki.util.Constants.BASE_URL
import com.example.animewiki.util.PaletteGenerator.convertImageToBitmap
import com.example.animewiki.util.PaletteGenerator.extractColorsFromBitmap
import kotlinx.coroutines.flow.collectLatest

@Composable
fun DetailsScreen(
    navController: NavHostController,
    detailsViewModel: DetailViewModel = hiltViewModel()
) {
    val selectedHero by detailsViewModel.selectedHero.collectAsState()
    val colorPalette by detailsViewModel.colorPalette
    val uiEvent by detailsViewModel.uiEvent

    if (colorPalette.isNotEmpty()) {
        DetailsContent(
            navController = navController,
            selectedHero = selectedHero,
            colors = colorPalette
        )
    } else {
        detailsViewModel.generateColorPalette()
    }

    val context = LocalContext.current

    LaunchedEffect(uiEvent) {
        when (uiEvent) {
            is UiEvent.GenerateColorPalette -> {
                val bitmap = convertImageToBitmap(
                    context = context,
                    imageUrl = "$BASE_URL${selectedHero?.image}"
                )
                bitmap?.let {
                    detailsViewModel.setColorPalette(colors = extractColorsFromBitmap(it))
                }
            }

            else -> {}
        }
    }
}