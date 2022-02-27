package org.student.travelnoteapp.data.room.repository

import androidx.lifecycle.LiveData
import org.student.travelnoteapp.data.room.dao.PlaceDao
import org.student.travelnoteapp.data.room.model.Place
import javax.inject.Inject

class PlaceRepository @Inject constructor(
    private val placeDao: PlaceDao
){

    val getAllPlaces: LiveData<List<Place>> = placeDao.getAllPlaces()

    fun getPlaceById(id: Long): LiveData<Place>{
        return placeDao.getPlaceById(id)
    }

    suspend fun addNewPlace(place: Place){
        placeDao.addNewPlace(place = place)
    }

    suspend fun updatePlace(place: Place){
        placeDao.addNewPlace(place = place)
    }

    suspend fun deletePlace(place: Place){
        placeDao.deletePlace(place = place)
    }

    suspend fun deletePlaceById(id: Long){
        placeDao.deletePlaceById(id)
    }

    suspend fun deleteAllPlaces(){
        placeDao.deleteAllPlaces()
    }

}