package com.example.animewiki.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.animewiki.util.Constants.HERO_REMOTE_KEYS_TABLE

@Entity(tableName = HERO_REMOTE_KEYS_TABLE)
data class HeroRemoteKeys(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val prevPage: Int?,
    val nextPage: Int?,
    val lastUpdated: Long? = null
)
