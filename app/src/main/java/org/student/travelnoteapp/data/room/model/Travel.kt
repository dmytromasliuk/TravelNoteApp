package org.student.travelnoteapp.data.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "travel_table")
data class Travel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val name: String,
    val description: String
)
