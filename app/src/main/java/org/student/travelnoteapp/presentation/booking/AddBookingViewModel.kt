package org.student.travelnoteapp.presentation.booking

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.student.travelnoteapp.data.room.repository.TravelRepository
import javax.inject.Inject

class AddBookingViewModel @Inject constructor(
    //private val travelRepository: TravelRepository
): ViewModel() {

    private val _title = mutableStateOf("")
    val title: State<String> = _title

    private val _email = mutableStateOf("")
    val email: State<String> = _email

    private val _phone = mutableStateOf("")
    val phone: State<String> = _phone

    private val _price = mutableStateOf("")
    val price: State<String> = _price

    fun setTitle(title: String){
        _title.value = title
    }

    fun setEmail(email: String){
        _email.value = email
    }

    fun setPhone(phone: String){
        _phone.value = phone
    }

    fun setPrice(price: String){
        _price.value = price
    }
}