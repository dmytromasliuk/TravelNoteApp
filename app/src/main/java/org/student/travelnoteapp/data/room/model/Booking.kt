package org.student.travelnoteapp.data.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "booking_table")
data class Booking(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val travelId: Long,
    val addressId: Long,
    val title: String,
    val email: String,
    val phone: String,
    val price: String
)
