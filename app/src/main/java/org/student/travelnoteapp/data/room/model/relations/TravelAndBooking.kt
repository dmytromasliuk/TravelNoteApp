package org.student.travelnoteapp.data.room.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import org.student.travelnoteapp.data.room.model.Booking
import org.student.travelnoteapp.data.room.model.Travel

data class TravelAndBooking(
    @Embedded
    val travel: Travel,
    @Relation(
        parentColumn = "id",
        entityColumn = "travelId"
    )
    val bookings: List<Booking>
)
