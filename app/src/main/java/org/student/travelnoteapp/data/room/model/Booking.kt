package org.student.travelnoteapp.data.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "booking_table")
data class Booking(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val travelId: Int,
    val addressId: Int,
    val title: String,
    val email: String,
    val phone: String,
    val price: String
)
