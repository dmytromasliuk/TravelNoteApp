package org.student.travelnoteapp.presentation.booking

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.student.travelnoteapp.data.room.dao.BookingDao
import org.student.travelnoteapp.data.room.repository.BookingRepository
import org.student.travelnoteapp.data.room.repository.TravelRepository
import javax.inject.Inject

@HiltViewModel
class BookingDetailsViewModel @Inject constructor(
    private val travelRepository: TravelRepository
): ViewModel() {
}