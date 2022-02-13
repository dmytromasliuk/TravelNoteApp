package org.student.travelnoteapp.presentation.booking

import androidx.lifecycle.ViewModel
import org.student.travelnoteapp.data.room.dao.BookingDao
import org.student.travelnoteapp.data.room.repository.BookingRepository
import org.student.travelnoteapp.data.room.repository.TravelRepository
import javax.inject.Inject

class BookingDetailsViewModel @Inject constructor(
    private val travelRepository: TravelRepository
): ViewModel() {
}