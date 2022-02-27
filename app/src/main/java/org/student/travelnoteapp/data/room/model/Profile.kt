package org.student.travelnoteapp.data.room.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "profile_table")
data class Profile(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val country: String
): Parcelable
