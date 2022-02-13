package org.student.travelnoteapp.data.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address_table")
data class Address(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val apartment: String,
    val building: String,
    val street: String,
    val city: String,
    val country: String
)
