package org.student.travelnoteapp.data.room.dao

import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import androidx.room.*
import kotlinx.coroutines.flow.Flow
import org.student.travelnoteapp.data.room.model.Ticket
import org.student.travelnoteapp.data.room.model.Travel
import org.student.travelnoteapp.data.room.model.relations.TravelWithAllInfo

@Dao
interface TravelDao {

    @Transaction
    @Query("SELECT * FROM travel_table ORDER BY id ASC")
    fun getAllTravels(): LiveData<List<TravelWithAllInfo>>

    @Transaction
    @Query("SELECT * FROM travel_table WHERE id=:id")
    fun getTravelById(id: Long): LiveData<TravelWithAllInfo>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewTravel(travel: Travel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewTicket(ticket: Ticket)

    @Update
    suspend fun updateTravel(travel: Travel)

    @Delete
    suspend fun deleteTravel(travel: Travel)

    @Query("DELETE FROM travel_table WHERE id=:id")
    suspend fun deleteTravelById(id: Long)

    @Query("DELETE FROM travel_table")
    suspend fun deleteAllTravels()

}