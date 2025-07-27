package com.example.animewiki.data.remote

import com.example.animewiki.domain.model.ApiResponse
import com.example.animewiki.domain.model.Hero

class FakeAnimeApi : AnimeApi {

    private val heroes = listOf(
        Hero(
            id = 1,
            name = "Naruto",
            image = "",
            about = "",
            month = "",
            day = "",
            rating = 5.0,
            power = 10,
            abilities = listOf(),
            family = listOf(),
            natureTypes = listOf()
        ),
        Hero(
            id = 2,
            name = "Sasuke",
            image = "",
            about = "",
            month = "",
            day = "",
            rating = 5.0,
            power = 10,
            abilities = listOf(),
            family = listOf(),
            natureTypes = listOf()
        ),
        Hero(
            id = 3,
            name = "Kakashi",
            image = "",
            about = "",
            month = "",
            day = "",
            rating = 5.0,
            power = 10,
            abilities = listOf(),
            family = listOf(),
            natureTypes = listOf()
        )
    )

    override suspend fun getAllHeroes(page: Int): ApiResponse {
        return ApiResponse(
            success = false
        )
    }

    override suspend fun searchHeroes(name: String): ApiResponse {
        val searchedHeroes = findHeroes(name)
        return ApiResponse(
            success = true,
            message = "Ok",
            heroes = searchedHeroes
        )
    }

    private fun findHeroes(name: String): List<Hero> {
        val found = mutableListOf<Hero>()
        return if (name.isNotEmpty()) {
            heroes.forEach { hero ->
                if (hero.name.lowercase().contains(name.lowercase())) {
                    found.add(hero)
                }
            }
            found
        } else {
            emptyList()
        }
    }
}