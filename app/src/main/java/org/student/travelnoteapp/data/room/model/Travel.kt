package org.student.travelnoteapp.data.room.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "travel_table")
data class Travel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val profileId: Int,
    val name: String,
    val description: String
): Parcelable
