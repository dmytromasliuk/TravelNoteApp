package org.student.travelnoteapp.presentation.place

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.student.travelnoteapp.data.room.model.Place
import org.student.travelnoteapp.data.room.repository.PlaceRepository
import org.student.travelnoteapp.data.room.repository.TravelRepository
import javax.inject.Inject

@HiltViewModel
class PlaceEditViewModel @Inject constructor(
    private val placeRepository: PlaceRepository
): ViewModel() {

    fun deletePlace(place: Place){
        viewModelScope.launch(Dispatchers.IO) {
            placeRepository.deletePlace(place)
        }
    }
}