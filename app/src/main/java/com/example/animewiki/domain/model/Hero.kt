package com.example.animewiki.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.animewiki.util.Constants.HERO_TABLE

/*
* This Hero class will actually represent table in our database.
* Entity in room corresponds to Table in SQL lite DB
* */

@Entity(tableName = HERO_TABLE)
data class Hero(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val name: String,
    val image: String,
    val about: String,
    val month: String,
    val day: String,
    val rating: Double,
    val power: Int,
    val abilities: List<String>,
    val family: List<String>,
    val natureTypes: List<String>
)
