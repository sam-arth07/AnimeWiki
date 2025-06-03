package com.example.animewiki.data.local.dao

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.animewiki.domain.model.Hero


@Dao
interface HeroDao {

    /*
    * DAO or Data Access Objects are the main classes where you define your database interactions.
    * They can include a variety of query methods.
    * */

    @Query("select * from hero_table order by id asc")
    fun getAllHeroes(): PagingSource<Int, Hero>

    /* *
    * Paging Source is the base class for an async loading snapshots of data.
    * */

    @Query("select * from hero_table where id=:heroId")
    fun getSelectedHero(heroId: Int): Hero

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addHeroes(heroes: List<Hero>)

    @Query("delete from hero_table")
    suspend fun deleteAllHeroes()

}