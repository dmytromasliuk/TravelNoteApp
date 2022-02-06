package org.student.travelnoteapp.data.room.model.relations

import androidx.room.Embedded
import androidx.room.Relation
import org.student.travelnoteapp.data.room.model.Profile
import org.student.travelnoteapp.data.room.model.Travel

data class ProfileAndTravel(
    @Embedded
    val profile: Profile,
    @Relation(
        entity = Travel::class,
        parentColumn = "id",
        entityColumn = "profileId"
    )
    val travels: List<TravelWithAllInfo>
)
