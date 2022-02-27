package org.student.travelnoteapp.presentation.place

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.student.travelnoteapp.data.room.model.Place
import org.student.travelnoteapp.data.room.repository.PlaceRepository
import javax.inject.Inject

@HiltViewModel
class PlaceDetailsViewModel @Inject constructor(
    private val placeRepository: PlaceRepository
): ViewModel() {

    fun getPlace(id: Long): LiveData<Place>{
        return placeRepository.getPlaceById(id)
    }

}