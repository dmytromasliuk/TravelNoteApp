package org.student.travelnoteapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.student.travelnoteapp.data.room.model.Ticket
import org.student.travelnoteapp.data.room.model.Travel

@Dao
interface TicketDao {

    @Query("SELECT * FROM ticket_table ORDER BY id ASC")
    fun getAllTickets(): LiveData<List<Ticket>>

    @Query("SELECT * FROM ticket_table WHERE id=:id")
    suspend fun getTicketById(id: Long): Ticket

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewTicket(ticket: Ticket)

    @Update
    suspend fun updateTicket(ticket: Ticket)

    @Delete
    suspend fun deleteTicket(ticket: Ticket)

    @Query("DELETE FROM ticket_table WHERE id=:id")
    suspend fun deleteTicketById(id: Long)

    @Query("DELETE FROM ticket_table")
    suspend fun deleteAllTickets()

}