package org.student.travelnoteapp.presentation.travel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.student.travelnoteapp.data.room.model.relations.TravelWithAllInfo
import org.student.travelnoteapp.data.room.repository.TravelRepository
import javax.inject.Inject

@HiltViewModel
class CurrentTravelTimetableViewModel @Inject constructor(
    private val travelRepository: TravelRepository
): ViewModel() {

    val travel: LiveData<TravelWithAllInfo> = travelRepository.getCurrentTravel()

}