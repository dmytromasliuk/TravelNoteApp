package org.student.travelnoteapp.presentation.ticket

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.student.travelnoteapp.data.room.dao.TicketDao
import org.student.travelnoteapp.data.room.model.Ticket
import org.student.travelnoteapp.data.room.repository.TicketRepository
import javax.inject.Inject

@HiltViewModel
class TicketDetailsViewModel @Inject constructor(
    private val ticketRepository: TicketRepository
): ViewModel() {

    fun getTicket(id: Long): LiveData<Ticket>{
        return ticketRepository.getTicketById(id)
    }

}