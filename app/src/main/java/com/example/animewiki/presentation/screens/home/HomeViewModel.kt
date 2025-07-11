package com.example.animewiki.presentation.screens.home

import androidx.lifecycle.ViewModel
import com.example.animewiki.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {
    val getAllHeroes = useCases.getAllHeroesUseCase()
}