package org.student.travelnoteapp.data.room.repository

import androidx.lifecycle.LiveData
import org.student.travelnoteapp.data.room.dao.TicketDao
import org.student.travelnoteapp.data.room.model.Ticket
import javax.inject.Inject

class TicketRepository @Inject constructor(
    private val ticketDao: TicketDao
){

    val getAllTickets: LiveData<List<Ticket>> = ticketDao.getAllTickets()

    fun getTicketById(id: Long): LiveData<Ticket>{
        return ticketDao.getTicketById(id)
    }

    suspend fun addNewTicket(ticket: Ticket){
        ticketDao.addNewTicket(ticket = ticket)
    }

    suspend fun updateTicket(ticket: Ticket){
        ticketDao.updateTicket(ticket = ticket)
    }

    suspend fun deleteTicket(ticket: Ticket){
        ticketDao.deleteTicket(ticket = ticket)
    }

    suspend fun deleteTicketById(id: Long){
        ticketDao.deleteTicketById(id)
    }

    suspend fun deleteAllTickets(){
        ticketDao.deleteAllTickets()
    }

}