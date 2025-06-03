package com.example.animewiki.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {
    @Serializable
    data object Splash : Screens()

    @Serializable
    data object Home : Screens()

    @Serializable
    data object Welcome : Screens()

    @Serializable
    data object Search : Screens()

    @Serializable
    data class Details(val heroId: Int) : Screens()
}