package org.student.travelnoteapp.presentation.travel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.student.travelnoteapp.data.room.model.Travel
import org.student.travelnoteapp.data.room.model.relations.TravelWithAllInfo
import org.student.travelnoteapp.data.room.repository.TravelRepository
import javax.inject.Inject

@HiltViewModel
class TravelEditViewModel @Inject constructor(
    private val travelRepository: TravelRepository
): ViewModel() {

    private val _travelNameText = mutableStateOf("")
    val travelNameText : State<String> = _travelNameText

    private val _descriptionText = mutableStateOf("")
    val descriptionText : State<String> = _descriptionText

    fun setTravelName(travelName: String){
        _travelNameText.value = travelName
    }

    fun setDescription(description: String){
        _descriptionText.value = description
    }

    fun getTravel(id: Int): LiveData<TravelWithAllInfo> {
        return travelRepository.getTravelById(id)
    }

    fun updateTravel(travel: Travel) {
        viewModelScope.launch(Dispatchers.IO){
            travelRepository.updateTravel(travel = travel)
        }
    }

    fun deleteTravel(id: Int) {
        viewModelScope.launch(Dispatchers.IO){
            travelRepository.deleteTravelById(id)
        }
    }

}