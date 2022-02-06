package org.student.travelnoteapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.student.travelnoteapp.data.room.model.Profile
import org.student.travelnoteapp.data.room.model.relations.ProfileAndTravel

@Dao
interface ProfileDao {

    @Transaction
    @Query("SELECT * FROM profile_table WHERE id=:id")
    fun getProfileById(id: Int): LiveData<ProfileAndTravel>

    @Update
    suspend fun updateProfile(profile: Profile)

}