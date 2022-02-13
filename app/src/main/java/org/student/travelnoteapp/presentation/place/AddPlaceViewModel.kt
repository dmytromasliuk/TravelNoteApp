package org.student.travelnoteapp.presentation.place

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.student.travelnoteapp.data.room.repository.TravelRepository
import javax.inject.Inject

class AddPlaceViewModel @Inject constructor(
    //private val travelRepository: TravelRepository
): ViewModel() {

    private val _title = mutableStateOf("")
    val title: State<String> = _title

    private val _description = mutableStateOf("")
    val description: State<String> = _description

    fun setTitle(title: String){
        _title.value = title
    }

    fun setDescription(description: String){
        _description.value = description
    }

}