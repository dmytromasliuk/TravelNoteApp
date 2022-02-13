package org.student.travelnoteapp.data.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "place_table")
data class Place(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val travelId: Int,
    val title: String,
    val description: String,
    val date: String,
    val time: String
)
