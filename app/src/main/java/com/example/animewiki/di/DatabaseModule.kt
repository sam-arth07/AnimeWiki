package com.example.animewiki.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.animewiki.data.local.AnimeDatabase
import com.example.animewiki.data.repository.LocalDataSourceImpl
import com.example.animewiki.domain.repository.LocalDataSource
import com.example.animewiki.util.Constants.ANIME_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AnimeDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = AnimeDatabase::class.java,
            name = ANIME_DATABASE
        ).build()
    }

    @Provides
    @Singleton
    fun provideLocalDatabase(
        animeDatabase: AnimeDatabase
    ): LocalDataSource {
        return LocalDataSourceImpl(animeDatabase = animeDatabase)
    }
}