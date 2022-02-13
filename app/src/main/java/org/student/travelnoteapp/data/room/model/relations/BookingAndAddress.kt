package org.student.travelnoteapp.data.room.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import org.student.travelnoteapp.data.room.model.Address
import org.student.travelnoteapp.data.room.model.Booking

data class BookingAndAddress(
    @Embedded
    val booking: Booking,
    @Relation(
        entity = Address::class,
        parentColumn = "addressId",
        entityColumn = "id"
    )
    val address: Address?
)
