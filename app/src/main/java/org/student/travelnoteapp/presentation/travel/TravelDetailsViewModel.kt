package org.student.travelnoteapp.presentation.travel

import android.media.audiofx.AudioEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.student.travelnoteapp.data.room.model.Booking
import org.student.travelnoteapp.data.room.model.Place
import org.student.travelnoteapp.data.room.model.Ticket
import org.student.travelnoteapp.data.room.model.Travel
import org.student.travelnoteapp.data.room.model.relations.BookingAndAddress
import org.student.travelnoteapp.data.room.model.relations.TravelWithAllInfo
import org.student.travelnoteapp.data.room.repository.BookingRepository
import org.student.travelnoteapp.data.room.repository.PlaceRepository
import org.student.travelnoteapp.data.room.repository.TicketRepository
import org.student.travelnoteapp.data.room.repository.TravelRepository
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TravelDetailsViewModel @Inject constructor(
    private val travelRepository: TravelRepository,
    private val ticketRepository: TicketRepository,
    private val bookingRepository: BookingRepository,
    private val placeRepository: PlaceRepository
): ViewModel() {

    private val _id = mutableStateOf(0)
    val id: State<Int> = _id

    private val _ticketId = mutableStateOf(0)
    val ticketId: State<Int> = _ticketId

    private val _travelNameText = mutableStateOf("")
    val travelNameText : State<String> = _travelNameText

    private val _descriptionText = mutableStateOf("")
    val descriptionText : State<String> = _descriptionText

    val tickets: List<Ticket>? = travelRepository.getTravelById(_id.value).value?.tickets
    val bookings: List<BookingAndAddress>? = travelRepository.getTravelById(_id.value).value?.bookings
    val places: List<Place>? = travelRepository.getTravelById(_id.value).value?.places

    fun getTravel(id: Int): LiveData<TravelWithAllInfo>{
        return travelRepository.getTravelById(id)
    }

    fun addTicket(){
        viewModelScope.launch(Dispatchers.IO) {
            ticketRepository.addNewTicket(
                Ticket(
                    0,
                    _id.value,
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    ""
                )
            )
        }
    }

    fun setViewModelTravelId(id: Int){
        _id.value = id
    }

    fun setTicketId(ticketId: Int){
        _ticketId.value = ticketId
    }

}