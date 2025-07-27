package com.example.animewiki.data.paging_source

import androidx.paging.PagingSource.*
import com.example.animewiki.data.remote.AnimeApi
import com.example.animewiki.data.remote.FakeAnimeApi
import com.example.animewiki.domain.model.Hero
import kotlinx.coroutines.test.runTest
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class SearchHeroesSourceTest {

    private lateinit var animeApi: AnimeApi
    private lateinit var heroes: List<Hero>

    @Before
    fun setup() {
        animeApi = FakeAnimeApi()
        heroes = listOf(
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
    }

    @Test
    fun `Search api with existing hero name, expect a single hero result, assert LoadResult_Page`() =
        runTest {
            val heroSource = SearchHeroesSource(animeApi = animeApi, query = "Naruto")
            assertEquals<LoadResult<Int, Hero>>(
                expected = LoadResult.Page(
                    data = listOf(heroes.first()),
                    prevKey = null,
                    nextKey = null
                ),
                actual = heroSource.load(
                    LoadParams.Refresh(
                        loadSize = 3,
                        placeholdersEnabled = false,
                        key = null
                    )
                )
            )
        }
    @Test
    fun `Search api with existing hero name, expect multiple hero result, assert LoadResult_Page`() =
        runTest {
            val heroSource = SearchHeroesSource(animeApi = animeApi, query = "s")
            assertEquals<LoadResult<Int, Hero>>(
                expected = LoadResult.Page(
                    data = listOf(heroes[1],heroes[2]),
                    prevKey = null,
                    nextKey = null
                ),
                actual = heroSource.load(
                    LoadParams.Refresh(
                        loadSize = 3,
                        placeholdersEnabled = false,
                        key = null
                    )
                )
            )
        }
    @Test
    fun `Search api with empty hero name, assert empty hero list and LoadResult_Page`() =
        runTest {
            val heroSource = SearchHeroesSource(animeApi = animeApi, query = "")
            assertEquals<LoadResult<Int, Hero>>(
                expected = LoadResult.Page(
                    data = listOf(),
                    prevKey = null,
                    nextKey = null
                ),
                actual = heroSource.load(
                    LoadParams.Refresh(
                        loadSize = 3,
                        placeholdersEnabled = false,
                        key = null
                    )
                )
            )
        }
    @Test
    fun `Search api with non_existing hero name, assert empty hero list and LoadResult_Page`() =
        runTest {
            val query = "Unknown"
            val heroSource = SearchHeroesSource(animeApi = animeApi, query = query)
            val loadResult = heroSource.load(
                LoadParams.Refresh(
                    loadSize = 3,
                    placeholdersEnabled = false,
                    key = null
                )
            )

            val result = animeApi.searchHeroes(query).heroes
            assertTrue { result.isEmpty() }
            assertTrue { loadResult is LoadResult.Page }
        }
}