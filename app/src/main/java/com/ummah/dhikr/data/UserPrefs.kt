package com.ummah.dhikr.data
import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
val Context.dataStore by preferencesDataStore("ummah_prefs")
class UserPrefs(private val ctx: Context){
 private val HOUR = intPreferencesKey("hour")
 private val MIN = intPreferencesKey("minute")
 fun timeFlow() = ctx.dataStore.data.map { it[HOUR] to it[MIN] }
 suspend fun saveTime(h:Int, m:Int){ ctx.dataStore.edit{ it[HOUR]=h; it[MIN]=m } }
}
