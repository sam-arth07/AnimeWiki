package com.example.animewiki.data.repository

import com.example.animewiki.data.local.AnimeDatabase
import com.example.animewiki.domain.model.Hero
import com.example.animewiki.domain.repository.LocalDataSource

class LocalDataSourceImpl(
    animeDatabase: AnimeDatabase
) : LocalDataSource {

    val heroDao = animeDatabase.heroDao()

    override suspend fun getSelectedHero(heroId: Int): Hero {
        return heroDao.getSelectedHero(heroId = heroId)
    }
}