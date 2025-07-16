package com.example.animewiki.domain.repository

import com.example.animewiki.domain.model.Hero

interface LocalDataSource {
    suspend fun getSelectedHero(heroId: Int): Hero
}