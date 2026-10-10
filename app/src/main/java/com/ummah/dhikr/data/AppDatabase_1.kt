package com.ummah.dhikr.data
import androidx.room.Database
import androidx.room.RoomDatabase
@Database(entities=[AdhkarEntity::class], version=1, exportSchema=false)
abstract class AppDatabase: RoomDatabase() { abstract fun adhkarDao(): AdhkarDao }
