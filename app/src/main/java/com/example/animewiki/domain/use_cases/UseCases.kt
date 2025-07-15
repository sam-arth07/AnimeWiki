package com.example.animewiki.domain.use_cases

import com.example.animewiki.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.example.animewiki.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.example.animewiki.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.example.animewiki.domain.use_cases.search_heroes.SearchHeroesUseCase


//This is a wrapper class that contains all the useCases
data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase,
    val getAllHeroesUseCase: GetAllHeroesUseCase,
    val searchHeroesUseCase: SearchHeroesUseCase
)