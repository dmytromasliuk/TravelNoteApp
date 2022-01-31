package org.student.travelnoteapp.presentation.travel

import android.media.audiofx.AudioEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.student.travelnoteapp.data.room.model.Travel
import org.student.travelnoteapp.data.room.repository.TravelRepository
import javax.inject.Inject

@HiltViewModel
class TravelDetailsViewModel @Inject constructor(
    private val travelRepository: TravelRepository
): ViewModel() {

    private val _travelNameText = mutableStateOf("")
    val travelNameText : State<String> = _travelNameText

    private val _descriptionText = mutableStateOf("")
    val descriptionText : State<String> = _descriptionText

    fun getTravelName(id: Int): State<String>{
        viewModelScope.launch(Dispatchers.Main){
            _travelNameText.value = travelRepository.getTravelById(id).name
        }
        return travelNameText
    }

    fun getTravelDescription(id: Int): State<String>{
        viewModelScope.launch(Dispatchers.Main){
            _descriptionText.value = travelRepository.getTravelById(id).description
        }
        return descriptionText
    }

}