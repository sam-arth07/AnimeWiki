package com.example.animewiki.data.repository

import androidx.paging.PagingData
import androidx.room.Query
import com.example.animewiki.domain.model.Hero
import com.example.animewiki.domain.repository.DataStoreOperations
import com.example.animewiki.domain.repository.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

/**
 * By specifying the return type as DataStore Operations,
 * we are telling Dagger Hilt that check all the modules for the function with the specified return type (here DataStoreOperations)
 * Because that function declares how we actually want to inject a particular dependency.
 * Here we actually want to inject DataStoreOperationsImpl which is also the return of the function in the RepositoryModule object.
 */

class Repository @Inject constructor(
    private val dataStore: DataStoreOperations,
    private val remote: RemoteDataSource
) {

    fun getAllHeroes(): Flow<PagingData<Hero>> {
        return remote.getAllHeroes()
    }

    fun searchHeroes(query: String): Flow<PagingData<Hero>> {
        return remote.searchHeroes(query)
    }

    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}