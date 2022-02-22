package org.student.travelnoteapp.presentation.travel

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.student.travelnoteapp.data.room.model.Travel
import org.student.travelnoteapp.data.room.model.relations.TravelWithAllInfo
import org.student.travelnoteapp.data.room.repository.TravelRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TravelEditViewModel @Inject constructor(
    private val travelRepository: TravelRepository
): ViewModel() {

    private var _id: Long = 0

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

    fun updateTravel(travel: Travel) {
        viewModelScope.launch(Dispatchers.IO){
            travelRepository.updateTravel(travel = travel)
        }
    }

    fun deleteTravel(id: Long) {
        viewModelScope.launch(Dispatchers.IO){
            travelRepository.deleteTravelById(id)
        }
    }

}