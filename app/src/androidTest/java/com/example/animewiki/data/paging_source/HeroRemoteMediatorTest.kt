package com.example.animewiki.data.paging_source

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingConfig
import androidx.paging.PagingState
import androidx.paging.RemoteMediator.*
import androidx.test.core.app.ApplicationProvider
import com.example.animewiki.data.local.AnimeDatabase
import com.example.animewiki.data.remote.FakeAnimeApi2
import com.example.animewiki.domain.model.Hero
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Test

class HeroRemoteMediatorTest {

    private lateinit var animeApi: FakeAnimeApi2
    private lateinit var animeDatabase: AnimeDatabase

    @Before
    fun setup() {
        animeApi = FakeAnimeApi2()
        animeDatabase = AnimeDatabase.create(
            context = ApplicationProvider.getApplicationContext(),
            useInMemory = true
        )
    }

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun refreshLoadReturnsSuccessWhenMoreDataIsPresent() =
        runTest {
            val remoteMediator = HeroRemoteMediator(
                animeApi = animeApi,
                animeDatabase = animeDatabase
            )
            val pagingState = PagingState<Int, Hero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
            )
            val result = remoteMediator.load(
                LoadType.REFRESH,
                pagingState
            )

            assertTrue(result is MediatorResult.Success)
            assertFalse((result as MediatorResult.Success).endOfPaginationReached)

        }

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun refreshLoadSuccessAndEndOfPaginationReturnsTrueWhenNoMoreData() =
        runTest {
            animeApi.clearData()
            val remoteMediator = HeroRemoteMediator(
                animeApi = animeApi,
                animeDatabase = animeDatabase
            )
            val pagingState = PagingState<Int, Hero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
            )
            val result = remoteMediator.load(
                LoadType.REFRESH,
                pagingState
            )

            assertTrue(result is MediatorResult.Success)
            assertTrue((result as MediatorResult.Success).endOfPaginationReached)

        }

    /**
    * Test fun for case when animeApi throws exception when fetching data
    */

    @OptIn(ExperimentalPagingApi::class)
    @Test
    fun refreshLoadReturnsErrorResultWhenErrorOccurs() =
        runTest {
            animeApi.addException()
            val remoteMediator = HeroRemoteMediator(
                animeApi = animeApi,
                animeDatabase = animeDatabase
            )
            val pagingState = PagingState<Int, Hero>(
                pages = listOf(),
                anchorPosition = null,
                config = PagingConfig(pageSize = 3),
                leadingPlaceholderCount = 0
            )
            val result = remoteMediator.load(
                LoadType.REFRESH,
                pagingState
            )

            assertTrue(result is MediatorResult.Error)
        }

    @After
    fun cleanup() {
        animeDatabase.clearAllTables()
    }
}