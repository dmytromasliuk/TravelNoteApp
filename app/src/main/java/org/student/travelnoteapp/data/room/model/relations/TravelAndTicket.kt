package org.student.travelnoteapp.data.room.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import org.student.travelnoteapp.data.room.model.Ticket
import org.student.travelnoteapp.data.room.model.Travel

data class TravelAndTicket(
    @Embedded val travel: Travel,
    @Relation(
        parentColumn = "id",
        entityColumn = "travelId"
    )
    val tickets: List<Ticket>
)
