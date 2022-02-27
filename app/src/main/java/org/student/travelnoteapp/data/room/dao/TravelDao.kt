package org.student.travelnoteapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
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

    @Transaction
    @Query("SELECT * FROM travel_table WHERE isCurrent=1")
    fun getCurrentTravel(): LiveData<TravelWithAllInfo>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewTravel(travel: Travel)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewTicket(ticket: Ticket)

    @Update
    suspend fun updateTravel(travel: Travel)

    @Query("UPDATE travel_table Set isCurrent = :current WHERE id = :id")
    suspend fun updateCurrentTravel(id: Long, current: Boolean)

    @Delete
    suspend fun deleteTravel(travel: Travel)

    @Query("DELETE FROM travel_table WHERE id=:id")
    suspend fun deleteTravelById(id: Long)

    @Query("DELETE FROM travel_table")
    suspend fun deleteAllTravels()

}