package org.student.travelnoteapp.data.room.repository

import androidx.lifecycle.LiveData
import org.student.travelnoteapp.data.room.dao.ProfileDao
import org.student.travelnoteapp.data.room.model.Profile
import org.student.travelnoteapp.data.room.model.relations.ProfileAndTravel
import javax.inject.Inject

class ProfileRepository @Inject constructor(
    private val profileDao: ProfileDao
) {

    fun getProfileById(id: Long): LiveData<ProfileAndTravel>{
        return profileDao.getProfileById(id)
    }

    fun getProfileByEmail(email: String): LiveData<ProfileAndTravel>{
        return profileDao.getProfileByEmail(email)
    }

    suspend fun createProfile(profile: Profile){
        profileDao.createProfile(profile)
    }

    suspend fun updateProfile(profile: Profile){
        profileDao.updateProfile(profile = profile)
    }

    suspend fun isExistByEmail(email: String): Boolean{
        return profileDao.isExistByEmail(email)
    }

    /*fun getProfileIdByEmail(email: String): Long {
        return profileDao.getProfileIdByEmail(email)
    }*/

}