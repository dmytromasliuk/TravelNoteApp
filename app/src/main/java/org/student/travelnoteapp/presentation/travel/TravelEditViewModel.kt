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

    private val _travelNameText: MutableLiveData<String> = MutableLiveData("")
    val travelNameText : MutableLiveData<String> = _travelNameText

    private val _descriptionText: MutableLiveData<String> = MutableLiveData("")
    val descriptionText : MutableLiveData<String> = _descriptionText

    var tmp: String? = ""

    //TODO: WTF???!!!
    init{
        viewModelScope.launch(Dispatchers.Main) {
            Timber.d("Id value in viewmodel ${_id}")
            val testTravel = travelRepository.getTravelById(_id)
            Timber.d( "Try to catch travel name: ${testTravel.value?.travel?.name.toString()}")


            Timber.d( "tmp value in viewmodel ${travelRepository.getTravelById(5).value?.travel?.name}")
            setTravelName(travelRepository.getTravelById(_id).value?.travel?.name.toString())
            Timber.d( "travelName value in viewmodel ${_travelNameText.value}")
            setDescription(travelRepository.getTravelById(_id).value?.travel?.description.toString())
            Timber.d("description in viewmodel ${_descriptionText.value}")
        }
    }

    fun setViewModelTravelId(id: Long){
         _id = id
    }

    fun setTravelName(travelName: String){
        _travelNameText.value = travelName
    }

    fun setDescription(description: String){
        _descriptionText.value = description
    }

    fun getTravel(id: Long): LiveData<TravelWithAllInfo> {
        return travelRepository.getTravelById(id)
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