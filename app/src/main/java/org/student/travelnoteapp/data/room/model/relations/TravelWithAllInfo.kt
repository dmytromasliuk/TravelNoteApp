package org.student.travelnoteapp.data.room.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import org.student.travelnoteapp.data.room.model.Booking
import org.student.travelnoteapp.data.room.model.Place
import org.student.travelnoteapp.data.room.model.Ticket
import org.student.travelnoteapp.data.room.model.Travel

data class TravelWithAllInfo(
    @Embedded
    val travel: Travel,
    @Relation(
        entity = Ticket::class,
        parentColumn = "id",
        entityColumn = "travelId"
    )
    val tickets: List<Ticket>,
    @Relation(
        entity = Place::class,
        parentColumn = "id",
        entityColumn = "travelId"
    )
    val places: List<Place>,
    @Relation(
        entity = Booking::class,
        parentColumn = "id",
        entityColumn = "travelId"
    )
    val bookings: List<BookingAndAddress>
)