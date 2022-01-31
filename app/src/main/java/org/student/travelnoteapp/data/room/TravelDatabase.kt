package org.student.travelnoteapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.student.travelnoteapp.data.room.dao.TicketDao
import org.student.travelnoteapp.data.room.dao.TravelDao
import org.student.travelnoteapp.data.room.model.Ticket
import org.student.travelnoteapp.data.room.model.Travel

@Database(
    entities = [Travel::class, Ticket::class],
    version = 2
)
abstract class TravelDatabase: RoomDatabase() {

    abstract fun travelDao(): TravelDao
    abstract fun ticketDao(): TicketDao

}