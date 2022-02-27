package org.student.travelnoteapp.data.room.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import org.student.travelnoteapp.data.room.model.Profile
import org.student.travelnoteapp.data.room.model.relations.ProfileAndTravel

@Dao
interface ProfileDao {

    @Transaction
    @Query("SELECT * FROM profile_table WHERE id=:id")
    fun getProfileById(id: Long): LiveData<ProfileAndTravel>

    @Transaction
    @Query("SELECT * FROM profile_table WHERE email=:email")
    fun getProfileByEmail(email: String): LiveData<ProfileAndTravel>

    @Transaction
    @Query("SELECT EXISTS(SELECT * FROM profile_table WHERE email=:email)")
    suspend fun isExistByEmail(email: String): Boolean

    @Insert
    suspend fun createProfile(profile: Profile)

    @Update
    suspend fun updateProfile(profile: Profile)

}