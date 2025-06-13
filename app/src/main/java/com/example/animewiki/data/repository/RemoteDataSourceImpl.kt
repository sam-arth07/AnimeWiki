package com.example.animewiki.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.animewiki.data.local.AnimeDatabase
import com.example.animewiki.data.paging_source.HeroRemoteMediator
import com.example.animewiki.data.remote.AnimeApi
import com.example.animewiki.domain.model.Hero
import com.example.animewiki.domain.repository.RemoteDataSource
import com.example.animewiki.util.Constants.HEROES_PER_PAGE
import kotlinx.coroutines.flow.Flow

@OptIn(ExperimentalPagingApi::class)
class RemoteDataSourceImpl(
    private val animeApi: AnimeApi, private val animeDatabase: AnimeDatabase
) : RemoteDataSource {

    val heroDao = animeDatabase.heroDao()

    override fun getAllHeroes(): Flow<PagingData<Hero>> {
        //This is where we call the pager class from paging 3 lib, specify paging config as well as paging source factory to return a flow
        val pagingSourceFactory = { heroDao.getAllHeroes() }
        return Pager(
            config = PagingConfig(pageSize = HEROES_PER_PAGE), remoteMediator = HeroRemoteMediator(
                animeApi = animeApi, animeDatabase = animeDatabase
            ), pagingSourceFactory = pagingSourceFactory
        ).flow
    }

    override fun searchHeroes(): Flow<PagingData<Hero>> {
        TODO("Not yet implemented")
    }

}