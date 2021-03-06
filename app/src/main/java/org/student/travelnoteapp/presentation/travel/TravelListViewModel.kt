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
class TravelListViewModel @Inject constructor(
    private val travelRepository: TravelRepository
    ): ViewModel() {

    val travels: LiveData<List<TravelWithAllInfo>> = travelRepository.getAllTravels

    private val _selectedTravel = mutableStateOf(-1L)
    val selectedTravel: State<Long> = _selectedTravel

    fun addNewTravel(travel: Travel){
        viewModelScope.launch(Dispatchers.IO) {
            travelRepository.addNewTravel(travel = travel)
        }
    }

    fun updateTravel(travel: Travel){
        viewModelScope.launch(Dispatchers.IO) {
            travelRepository.updateTravel(travel = travel)
        }
    }

    fun updateCurrentTravel(id: Long, current: Boolean){
        viewModelScope.launch(Dispatchers.IO) {
            travelRepository.updateCurrentTravel(id, current)
        }
    }

    fun deleteTravel(travel: Travel){
        viewModelScope.launch(Dispatchers.IO) {
            travelRepository.deleteTravel(travel = travel)
        }
    }

    fun deleteAllTravels(){
        viewModelScope.launch(Dispatchers.IO){
            travelRepository.deleteAllTravels()
        }
    }

    fun setSelectedTravel(selected: Long){
        _selectedTravel.value = selected
    }

}