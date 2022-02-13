package org.student.travelnoteapp.presentation.ticket

import androidx.lifecycle.ViewModel
import org.student.travelnoteapp.data.room.dao.TicketDao
import org.student.travelnoteapp.data.room.repository.TicketRepository
import javax.inject.Inject

class TicketDetailsViewModel @Inject constructor(
    private val ticketRepository: TicketRepository
): ViewModel() {
}