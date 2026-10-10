package com.ummah.dhikr.data
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName="adhkar")
data class AdhkarEntity(
    @PrimaryKey val id: Int,
    val arabic: String,
    val transliteration: String,
    val translation: String,
    val virtue: String,
    val source: String,
    val category: String,
    val targetCount: Int = 33
)
