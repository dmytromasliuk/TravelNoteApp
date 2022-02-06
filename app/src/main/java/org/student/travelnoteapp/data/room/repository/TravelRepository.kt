package org.student.travelnoteapp.data.room.repository

import android.app.Application
import androidx.compose.runtime.MutableState
import androidx.lifecycle.LiveData
import kotlinx.coroutines.flow.Flow
import org.student.travelnoteapp.data.room.TravelDatabase
import org.student.travelnoteapp.data.room.dao.TravelDao
import org.student.travelnoteapp.data.room.model.Travel
import org.student.travelnoteapp.data.room.model.relations.TravelWithAllInfo
import javax.inject.Inject

class TravelRepository @Inject constructor(
    private val travelDao: TravelDao
){

    val getAllTravels: LiveData<List<TravelWithAllInfo>> = travelDao.getAllTravels()

    fun getTravelById(id: Int): LiveData<TravelWithAllInfo>{
        return travelDao.getTravelById(id)
    }

    suspend fun addNewTravel(travel: Travel){
        travelDao.addNewTravel(travel)
    }

    suspend fun updateTravel(travel: Travel){
        travelDao.updateTravel(travel = travel)
    }

    suspend fun deleteTravelById(id: Int){
        travelDao.deleteTravelById(id)
    }

    suspend fun deleteTravel(travel: Travel){
        travelDao.deleteTravel(travel = travel)
    }

    suspend fun deleteAllTravels(){
        travelDao.deleteAllTravels()
    }
}