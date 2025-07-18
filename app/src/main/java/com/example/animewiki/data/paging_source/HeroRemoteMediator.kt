package com.example.animewiki.data.paging_source

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import com.example.animewiki.data.local.AnimeDatabase
import com.example.animewiki.data.remote.AnimeApi
import com.example.animewiki.domain.model.Hero
import com.example.animewiki.domain.model.HeroRemoteKeys
import jakarta.inject.Inject
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Remote Mediator will fetch data from AnimeApi & store directly into the AnimeDatabase.
 */

@OptIn(ExperimentalPagingApi::class)
class HeroRemoteMediator(
    private val animeApi: AnimeApi, private val animeDatabase: AnimeDatabase
) : RemoteMediator<Int, Hero>() {

    private val heroDao = animeDatabase.heroDao()
    private val heroRemoteKeysDao = animeDatabase.heroRemoteKeysDao()

    /**
    * Initialize function is called before any loading is performed. It is used to check if the cached data is expired
    * and decide whether to trigger refresh.
    * @return InitializeAction.LAUNCH_INITIAL_REFRESH //When local data needs to be fully refreshed.
     *
     * InitializeAction.SKIP_INITIAL_REFRESH // When local data does not need to be refreshed.
    */
    override suspend fun initialize(): InitializeAction {
        val currentTime = System.currentTimeMillis()
        val lastUpdated = heroRemoteKeysDao.getRemoteKeys(heroId = 1)?.lastUpdated ?: 0
        val cacheTimeout = 1440 // Cache Data for 1day = 24hrs = 24 * 60 = 1440
        val diffInMinutes = (currentTime - lastUpdated) / 1000 / 60
        return if (diffInMinutes.toInt() < cacheTimeout) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType, state: PagingState<Int, Hero>
    ): MediatorResult {
        return try {
            //Logic to dynamically get the page number from the loadType param

            val page = when (loadType) {
                LoadType.REFRESH -> {
                    //When we invalidate our local cached data or when we initialize the db (if run the application for the first time)
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextPage?.minus(1) ?: 1
                }

                LoadType.PREPEND -> {
                    // When we need to get the remote keys from our local database for the first item
                    //why for the first item? Ans: Bcoz Prepend load type will be triggered at the start of paging data
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevPage = remoteKeys?.prevPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    prevPage
                }

                LoadType.APPEND -> {
                    //When we need to get remote key for the last item in the database.
                    //Triggered when we need to fetch new data and append it to the end of the existing data.
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextPage = remoteKeys?.nextPage ?: return MediatorResult.Success(
                        endOfPaginationReached = remoteKeys != null
                    )
                    nextPage
                }
            }

            //Make Request to server
            val response = animeApi.getAllHeroes(page = page)
            if (response.heroes.isNotEmpty()) {
                // If the response from the server is not empty only then we want to save that data to our database
                animeDatabase.withTransaction { //withTransaction allows us to execute multiple database operations, sequentially one by one
                    if (loadType == LoadType.REFRESH) {
                        //Means we are invalidating our data
                        //In this case we want to clear our two database tables.
                        heroDao.deleteAllHeroes()
                        heroRemoteKeysDao.deleteAllRemoteKeys()
                    }
                    val prevPage = response.prevPage
                    val nextPage = response.nextPage
                    val keys = response.heroes.map { hero ->
                        HeroRemoteKeys(
                            id = hero.id,
                            nextPage = nextPage,
                            prevPage = prevPage,
                            lastUpdated = response.lastUpdated
                        )
                    }
                    //Add the updated keys and hero data to our tables
                    heroRemoteKeysDao.addAllRemoteKeys(heroRemoteKeys = keys)
                    heroDao.addHeroes(heroes = response.heroes)
                }
            }
            MediatorResult.Success(endOfPaginationReached = response.nextPage == null)
        } catch (e: Exception) {
            return MediatorResult.Error(e)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, Hero>): HeroRemoteKeys? {
        return state.pages.lastOrNull { it.data.isNotEmpty() }?.data?.lastOrNull()?.let { hero ->
            heroRemoteKeysDao.getRemoteKeys(
                heroId = hero.id
            )
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, Hero>): HeroRemoteKeys? {
        return state.pages.firstOrNull { it.data.isNotEmpty() }?.data?.firstOrNull()?.let { hero ->
            heroRemoteKeysDao.getRemoteKeys(
                heroId = hero.id
            )
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(
        state: PagingState<Int, Hero>
    ): HeroRemoteKeys? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.id?.let { id ->
                heroRemoteKeysDao.getRemoteKeys(heroId = id)
            }
        }
    }


//    private fun parseMillis(millis: Long): String {
//        val date = Date(millis)
//        val format = SimpleDateFormat("HH:mm", Locale.ROOT)
//        return format.format(date)
//    }
}