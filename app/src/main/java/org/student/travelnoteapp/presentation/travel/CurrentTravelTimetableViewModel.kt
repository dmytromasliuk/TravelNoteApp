package org.student.travelnoteapp.presentation.travel

import androidx.compose.runtime.livedata.observeAsState
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.student.travelnoteapp.data.room.model.relations.TravelWithAllInfo
import org.student.travelnoteapp.data.room.repository.TravelRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class CurrentTravelTimetableViewModel @Inject constructor(
    private val travelRepository: TravelRepository
): ViewModel() {

    val travel: LiveData<TravelWithAllInfo> = travelRepository.getCurrentTravel()

}