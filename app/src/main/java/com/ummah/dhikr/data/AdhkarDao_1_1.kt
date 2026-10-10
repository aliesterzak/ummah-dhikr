package com.ummah.dhikr.data
import androidx.room.*
@Dao
interface AdhkarDao {
    @Query("SELECT * FROM adhkar") suspend fun getAll(): List<AdhkarEntity>
    @Query("SELECT * FROM adhkar WHERE id=:id") suspend fun getById(id:Int): AdhkarEntity?
    @Insert(onConflict = OnConflictStrategy.REPLACE) suspend fun insertAll(list:List<AdhkarEntity>)
}
