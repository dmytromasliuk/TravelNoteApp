package org.student.travelnoteapp.presentation.ticket

import androidx.lifecycle.ViewModel
import org.student.travelnoteapp.data.room.repository.TravelRepository
import javax.inject.Inject

class TicketEditViewModel @Inject constructor(
    private val travelRepository: TravelRepository
    ): ViewModel() {



}