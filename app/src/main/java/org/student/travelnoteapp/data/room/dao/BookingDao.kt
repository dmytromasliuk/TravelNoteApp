package org.student.travelnoteapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.student.travelnoteapp.data.room.model.Address
import org.student.travelnoteapp.data.room.model.Booking
import org.student.travelnoteapp.data.room.model.relations.BookingAndAddress

@Dao
interface BookingDao {

    @Transaction
    @Query("SELECT * FROM booking_table ORDER BY id ASC")
    fun getAllBookings(): LiveData<List<BookingAndAddress>>

    @Transaction
    @Query("SELECT * FROM booking_table WHERE id=:id")
    fun getBookingById(id: Int): LiveData<BookingAndAddress>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewBooking(booking: Booking)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addNewAddress(address: Address)

    @Update
    suspend fun updateBooking(booking: Booking)

    @Delete
    suspend fun deleteBooking(booking: Booking)

    @Query("DELETE FROM booking_table WHERE id=:id")
    suspend fun deleteBookingById(id: Int)

    @Query("DELETE FROM booking_table")
    suspend fun deleteAllBookings()

}