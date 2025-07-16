package com.example.animewiki.presentation.screens.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animewiki.domain.model.Hero
import com.example.animewiki.domain.use_cases.UseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _selectedHero: MutableStateFlow<Hero?> = MutableStateFlow(null)
    val selectedHero: StateFlow<Hero?> = _selectedHero

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val heroId = savedStateHandle.get<Int>("heroId")
            _selectedHero.value = heroId?.let { useCases.getSelectedHeroUseCase(heroId) }
        }
    }

    private val _uiEvent: MutableState<UiEvent?> = mutableStateOf(null)
    val uiEvent: State<UiEvent?> = _uiEvent

    private val _colorPalette : MutableState<Map<String, String>> = mutableStateOf(mapOf())
    val colorPalette : State<Map<String, String>> = _colorPalette



    fun generateColorPalette() {
        viewModelScope.launch {
            _uiEvent.value = UiEvent.GenerateColorPalette
        }
    }

    fun setColorPalette(colors: Map<String, String>) {
        _colorPalette.value = colors
    }

}


sealed class UiEvent {
    object GenerateColorPalette : UiEvent()
}