package org.student.travelnoteapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.student.travelnoteapp.data.room.model.Travel

@Dao
interface TravelDao {

    @Query("SELECT * FROM travel_table ORDER BY id ASC")
    fun getAllTravels(): LiveData<List<Travel>>

    @Query("SELECT * FROM travel_table WHERE id=:id")
    fun getTravelById(id: Int): Travel

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewTravel(travel: Travel)

    @Update
    suspend fun updateTravel(travel: Travel)

    @Delete
    suspend fun deleteTravel(travel: Travel)

    @Query("DELETE FROM travel_table")
    suspend fun deleteAllTravels()



}