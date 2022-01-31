package org.student.travelnoteapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.student.travelnoteapp.data.room.model.Ticket
import org.student.travelnoteapp.data.room.model.Travel

@Dao
interface TravelDao {

    @Transaction
    @Query("SELECT * FROM travel_table ORDER BY id ASC")
    fun getAllTravels(): LiveData<List<Travel>>

    @Transaction
    @Query("SELECT * FROM travel_table WHERE id=:id")
    suspend fun getTravelById(id: Int): Travel

    @Transaction
    @Query("SELECT * FROM travel_table ORDER BY id ASC")
    suspend fun getAllTravelsWithTickets(): List<Travel>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewTravel(travel: Travel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewTicket(ticket: Ticket)

    @Update
    suspend fun updateTravel(travel: Travel)

    @Delete
    suspend fun deleteTravel(travel: Travel)

    @Query("DELETE FROM travel_table WHERE id=:id")
    suspend fun deleteTravelById(id: Int)

    @Query("DELETE FROM travel_table")
    suspend fun deleteAllTravels()



}