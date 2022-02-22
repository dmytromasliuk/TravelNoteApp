package org.student.travelnoteapp.data.room.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "travel_table")
data class Travel(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val profileId: Long,
    val name: String,
    val description: String,
    val isCurrent: Boolean
): Parcelable
