package org.student.travelnoteapp.data.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
import java.time.LocalTime

@Entity(tableName = "ticket_table")
data class Ticket(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val travelId: Long,
    val ticketNumber: String,
    val destinationFrom: String,
    val destinationTo: String,
    val vehicle: String,
    val price: String,
    val date: String,
    val time: String
)
