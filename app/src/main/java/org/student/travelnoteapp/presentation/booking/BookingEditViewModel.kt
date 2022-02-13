package org.student.travelnoteapp.presentation.booking

import androidx.lifecycle.ViewModel
import org.student.travelnoteapp.data.room.repository.TravelRepository
import javax.inject.Inject

class BookingEditViewModel @Inject constructor(
    private val travelRepository: TravelRepository
): ViewModel() {
}