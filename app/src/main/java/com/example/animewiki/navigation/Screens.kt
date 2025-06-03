package com.example.animewiki.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Screens {
    @Serializable
    object Splash : Screens()

    @Serializable
    object Home : Screens()

    @Serializable
    object Welcome : Screens()

    @Serializable
    object Search : Screens()

    @Serializable
    data class Details(val heroId: Int) : Screens()
}