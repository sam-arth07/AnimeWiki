package com.example.animewiki.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.animewiki.domain.model.HeroRemoteKeys

@Dao
interface HeroRemoteKeysDao {

    @Query("select * from hero_remote_keys_table where id=:heroId")
    suspend fun getRemoteKeys(heroId: Int): HeroRemoteKeys?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAllRemoteKeys(heroRemoteKeys: List<HeroRemoteKeys>)

    @Query("delete from hero_remote_keys_table")
    suspend fun deleteAllRemoteKeys()
}