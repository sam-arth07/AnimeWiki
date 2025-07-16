package com.example.animewiki.data.paging_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.animewiki.data.remote.AnimeApi
import com.example.animewiki.domain.model.Hero
import jakarta.inject.Inject

class SearchHeroesSource (
    private val animeApi: AnimeApi,
    private val query: String
) : PagingSource<Int, Hero>() {
    override fun getRefreshKey(state: PagingState<Int, Hero>): Int? {
        return state.anchorPosition
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Hero> {
        return try {
            val response = animeApi.searchHeroes(query)
            val heroes = response.heroes
            if (heroes.isNotEmpty()) {
                LoadResult.Page(
                    data = heroes,
                    prevKey = response.prevPage,
                    nextKey = response.nextPage
                )
            } else {
                LoadResult.Page(
                    data = emptyList(),
                    prevKey = null,
                    nextKey = null
                )
            }
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    }

}