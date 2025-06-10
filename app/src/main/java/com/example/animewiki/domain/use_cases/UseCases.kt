package com.example.animewiki.domain.use_cases

import com.example.animewiki.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.example.animewiki.domain.use_cases.save_onboarding.SaveOnBoardingUseCase


//This is a wrapper class that contains all the useCases
data class UseCases(
    val saveOnBoardingUseCase: SaveOnBoardingUseCase,
    val readOnBoardingUseCase: ReadOnBoardingUseCase
)