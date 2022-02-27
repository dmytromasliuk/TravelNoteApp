package org.student.travelnoteapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.student.travelnoteapp.data.room.model.Place

@Dao
interface PlaceDao {

    @Transaction
    @Query("SELECT * FROM place_table ORDER BY id ASC")
    fun getAllPlaces(): LiveData<List<Place>>

    @Transaction
    @Query("SELECT * FROM place_table WHERE id=:id")
    fun getPlaceById(id: Long): LiveData<Place>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewPlace(place: Place)

    @Update
    suspend fun updatePlace(place: Place)

    @Delete
    suspend fun deletePlace(place: Place)

    @Query("DELETE FROM place_table WHERE id=:id")
    suspend fun deletePlaceById(id: Long)

    @Query("DELETE FROM travel_table")
    suspend fun deleteAllPlaces()

}