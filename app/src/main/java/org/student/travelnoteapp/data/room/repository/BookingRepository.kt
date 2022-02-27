package org.student.travelnoteapp.data.room.repository

import androidx.lifecycle.LiveData
import org.student.travelnoteapp.data.room.dao.BookingDao
import org.student.travelnoteapp.data.room.model.Address
import org.student.travelnoteapp.data.room.model.Booking
import org.student.travelnoteapp.data.room.model.relations.BookingAndAddress
import javax.inject.Inject

class BookingRepository @Inject constructor(
    private val bookingDao: BookingDao
){

    val getAllBookings: LiveData<List<BookingAndAddress>> = bookingDao.getAllBookings()

    fun getBookingById(id: Long): LiveData<BookingAndAddress>{
        return bookingDao.getBookingById(id = id)
    }

    suspend fun addNewBooking(booking: Booking){
        bookingDao.addNewBooking(booking = booking)
    }

    suspend fun addNewAddress(address: Address): Long{
        return bookingDao.addNewAddress(address = address)
    }

    suspend fun updateBooking(booking: Booking){
        bookingDao.updateBooking(booking = booking)
    }

    suspend fun deleteBooking(booking: Booking){
        bookingDao.deleteBooking(booking = booking)
    }

    suspend fun deleteBookingById(id: Long){
        bookingDao.deleteBookingById(id = id)
    }

    suspend fun deleteAllBooking(){
        bookingDao.deleteAllBookings()
    }

}