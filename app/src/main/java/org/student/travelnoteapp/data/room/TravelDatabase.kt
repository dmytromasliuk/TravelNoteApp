package org.student.travelnoteapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.student.travelnoteapp.data.room.dao.*
import org.student.travelnoteapp.data.room.model.*

@Database(
    entities = [
        Profile::class,
        Travel::class,
        Ticket::class,
        Place::class,
        Booking::class,
        Address::class],
    version = 9
)
abstract class TravelDatabase: RoomDatabase() {

    abstract fun profileDao(): ProfileDao
    abstract fun travelDao(): TravelDao
    abstract fun ticketDao(): TicketDao
    abstract fun placeDao(): PlaceDao
    abstract fun bookingDao(): BookingDao
    abstract fun addressDao(): AddressDao

}