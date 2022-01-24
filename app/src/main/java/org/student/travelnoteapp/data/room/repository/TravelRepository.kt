package org.student.travelnoteapp.data.room.repository

import android.app.Application
import androidx.lifecycle.LiveData
import org.student.travelnoteapp.data.room.TravelDatabase
import org.student.travelnoteapp.data.room.dao.TravelDao
import org.student.travelnoteapp.data.room.model.Travel
import javax.inject.Inject

class TravelRepository @Inject constructor(
    private val travelDao: TravelDao
){

    val getAllTravels: LiveData<List<Travel>> = travelDao.getAllTravels()

    suspend fun addNewTravel(travel: Travel){
        travelDao.addNewTravel(travel)
    }

    suspend fun updateTravel(travel: Travel){
        travelDao.updateTravel(travel = travel)
    }

    suspend fun deleteTravel(travel: Travel){
        travelDao.deleteTravel(travel = travel)
    }

    suspend fun deleteAllTravels(){
        travelDao.deleteAllTravels()
    }
}