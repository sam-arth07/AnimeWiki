package com.example.animewiki.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.animewiki.data.local.dao.HeroDao
import com.example.animewiki.data.local.dao.HeroRemoteKeysDao
import com.example.animewiki.domain.model.Hero
import com.example.animewiki.domain.model.HeroRemoteKeys

@Database(entities = [Hero::class, HeroRemoteKeys::class], version = 1)
@TypeConverters(DatabaseConverter::class)
abstract class AnimeDatabase : RoomDatabase() {

    companion object {
        fun create(context: Context, useInMemory: Boolean) : AnimeDatabase {
            val databaseBuilder = if(useInMemory) {
                Room.inMemoryDatabaseBuilder(context, AnimeDatabase::class.java)
            } else {
                Room.databaseBuilder(context, AnimeDatabase::class.java,"test_database.db")
            }
            return databaseBuilder
                .fallbackToDestructiveMigration()
                .build()

        }
    }

    abstract fun heroDao(): HeroDao
    abstract fun heroRemoteKeysDao(): HeroRemoteKeysDao
}