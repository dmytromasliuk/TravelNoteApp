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

    private val _country = mutableStateOf("")
    val country: State<String> = _country

    private val _city = mutableStateOf("")
    val city: State<String> = _city

    private val _street = mutableStateOf("")
    val street: State<String> = _street

    private val _building = mutableStateOf("")
    val building: State<String> = _building

    private val _apartment = mutableStateOf("")
    val apartment: State<String> = _apartment

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

    fun setCountry(country: String){
        _country.value = country
    }

    fun setCity(city: String){
        _city.value = city
    }

    fun setStreet(street: String){
        _street.value = street
    }

    fun setBuilding(building: String){
        _building.value = building
    }

    fun setApartment(apartment: String){
        _apartment.value = apartment
    }
}