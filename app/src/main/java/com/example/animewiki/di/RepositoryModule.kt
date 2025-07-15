package com.example.animewiki.di

import android.content.Context
import com.example.animewiki.data.repository.DataStoreOperationsImpl
import com.example.animewiki.data.repository.Repository
import com.example.animewiki.domain.repository.DataStoreOperations
import com.example.animewiki.domain.use_cases.UseCases
import com.example.animewiki.domain.use_cases.get_all_heroes.GetAllHeroesUseCase
import com.example.animewiki.domain.use_cases.read_onboarding.ReadOnBoardingUseCase
import com.example.animewiki.domain.use_cases.save_onboarding.SaveOnBoardingUseCase
import com.example.animewiki.domain.use_cases.search_heroes.SearchHeroesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providesDataStoreOperations(
        @ApplicationContext context: Context
    ): DataStoreOperations {
        return DataStoreOperationsImpl(context = context)
    }

    @Provides
    @Singleton
    fun provideUseCases(repository: Repository): UseCases {
        return UseCases(
            saveOnBoardingUseCase = SaveOnBoardingUseCase(repository = repository),
            readOnBoardingUseCase = ReadOnBoardingUseCase(repository = repository),
            getAllHeroesUseCase = GetAllHeroesUseCase(repository = repository),
            searchHeroesUseCase = SearchHeroesUseCase(repository = repository)
        )
    }
}