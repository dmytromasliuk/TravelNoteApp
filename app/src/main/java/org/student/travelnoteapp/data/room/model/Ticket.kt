package org.student.travelnoteapp.data.room.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
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
): Parcelable
