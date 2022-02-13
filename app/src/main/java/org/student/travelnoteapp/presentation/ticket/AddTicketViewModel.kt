package org.student.travelnoteapp.presentation.ticket

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.util.*
import javax.inject.Inject

class AddTicketViewModel @Inject constructor(
    //private val travelRepository: TravelRepository
): ViewModel() {

    private val _ticketNumber = mutableStateOf("")
    val ticketNumber : State<String> = _ticketNumber

    private val _destinationFrom = mutableStateOf("")
    val destinationFrom : State<String> = _destinationFrom

    private val _destinationTo = mutableStateOf("")
    val destinationTo : State<String> = _destinationTo

    private val _selectedVehicle = mutableStateOf("")
    val selectedVehicle: State<String> = _selectedVehicle

    private val _price = mutableStateOf("")
    val price : State<String> = _price

    private val _date = mutableStateOf("")
    val date : State<String> = _date

    private val _time = mutableStateOf("")
    val time : State<String> = _time

    fun setTicketNumber(ticketNumber: String){
        _ticketNumber.value = ticketNumber
    }

    fun setDestinationFrom(destinationFrom: String){
        _destinationFrom.value = destinationFrom
    }

    fun setDestinationTo(destinationTo: String){
        _destinationTo.value = destinationTo
    }

    fun setSelectedVehicle(selectedVehicle: String){
        _selectedVehicle.value = selectedVehicle
    }

    fun setPrice(price: String){
        _price.value = price
    }

    fun setDate(date: String){
        _date.value = date
    }

    fun setTime(time: String){
        _time.value = time
    }

    fun selectDate(context: Context){
        var date = ""
        val currentTime = Calendar.getInstance()
        val year = currentTime.get(Calendar.YEAR)
        val month = currentTime.get(Calendar.MONTH)
        val day = currentTime.get(Calendar.DAY_OF_MONTH)
        DatePickerDialog(context, { _, y, m, d ->
            val pickedTime = Calendar.getInstance()
            pickedTime.set(y, m, d, 0, 0)
            val mStr: String
            if ((m + 1).toString().length == 1) {
                mStr = "0${m + 1}"
            } else {
                mStr = m.toString()
            }
            date = "$d/$mStr/$y"
            setDate(date)
        }, year, month, day).show()
    }

    fun selectTime(context: Context){
        var time = ""
        val currentTime = Calendar.getInstance()
        val hour = currentTime.get(Calendar.HOUR)
        val minutes = currentTime.get(Calendar.MINUTE)
        TimePickerDialog(context, {_, h, m ->
            val pickedTime = Calendar.getInstance()
            pickedTime.set(0,0,0, h, m)
            time = "$h:$m"
            setTime(time)
        }, hour, minutes, true).show()
    }

}