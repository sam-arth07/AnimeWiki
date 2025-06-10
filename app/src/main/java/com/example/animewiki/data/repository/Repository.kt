package com.example.animewiki.data.repository

import com.example.animewiki.domain.repository.DataStoreOperations
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class Repository @Inject constructor(
    //By specifying the return type as DataStore Operations,
    //we are telling Dagger Hilt that check all the modules for the function with the specified return type (here DataStoreOperations)
    //Because that function declares how we actually want to inject a particular dependency.
    //Here we actually want to inject DataStoreOperationsImpl which is also the return of the function in the RepositoryModule object.
    private val dataStore: DataStoreOperations
) {
    suspend fun saveOnBoardingState(completed: Boolean) {
        dataStore.saveOnBoardingState(completed = completed)
    }

    fun readOnBoardingState(): Flow<Boolean> {
        return dataStore.readOnBoardingState()
    }
}