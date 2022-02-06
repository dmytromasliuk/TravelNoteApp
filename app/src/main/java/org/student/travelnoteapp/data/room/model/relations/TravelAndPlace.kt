package org.student.travelnoteapp.data.room.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import org.student.travelnoteapp.data.room.model.Place
import org.student.travelnoteapp.data.room.model.Travel

data class TravelAndPlace (
    @Embedded
    val travel: Travel,
    @Relation(
        parentColumn = "id",
        entityColumn = "travelId"
    )
    val places: List<Place>

)