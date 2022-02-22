package org.student.travelnoteapp.presentation.booking

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.student.travelnoteapp.data.room.dao.BookingDao
import org.student.travelnoteapp.data.room.model.Booking
import org.student.travelnoteapp.data.room.model.relations.BookingAndAddress
import org.student.travelnoteapp.data.room.repository.BookingRepository
import org.student.travelnoteapp.data.room.repository.TravelRepository
import javax.inject.Inject

@HiltViewModel
class BookingDetailsViewModel @Inject constructor(
    private val bookingRepository: BookingRepository
): ViewModel() {

    fun getBooking(id: Long): LiveData<BookingAndAddress>{
        return bookingRepository.getBookingById(id)
    }

}