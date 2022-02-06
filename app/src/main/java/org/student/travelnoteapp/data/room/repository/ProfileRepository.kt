package org.student.travelnoteapp.data.room.repository

import androidx.lifecycle.LiveData
import org.student.travelnoteapp.data.room.dao.ProfileDao
import org.student.travelnoteapp.data.room.model.Profile
import org.student.travelnoteapp.data.room.model.relations.ProfileAndTravel
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val profileDao: ProfileDao
) {

    fun getProfileById(id: Int): LiveData<ProfileAndTravel>{
        return profileDao.getProfileById(id)
    }

    suspend fun updateProfile(profile: Profile){
        profileDao.updateProfile(profile = profile)
    }

}