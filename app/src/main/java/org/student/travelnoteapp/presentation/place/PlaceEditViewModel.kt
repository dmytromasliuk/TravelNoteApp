package org.student.travelnoteapp.presentation.place

import androidx.lifecycle.ViewModel
import org.student.travelnoteapp.data.room.repository.TravelRepository
import javax.inject.Inject

class PlaceEditViewModel @Inject constructor(
    private val travelRepository: TravelRepository
): ViewModel() {
}