package org.student.travelnoteapp.presentation.place

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Context
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import org.student.travelnoteapp.data.room.repository.TravelRepository
import java.util.*
import javax.inject.Inject

class AddPlaceViewModel @Inject constructor(
    //private val travelRepository: TravelRepository
): ViewModel() {

    private val _title = mutableStateOf("")
    val title: State<String> = _title

    private val _description = mutableStateOf("")
    val description: State<String> = _description

    private val _date = mutableStateOf("")
    val date: State<String> = _date

    private val _time = mutableStateOf("")
    val time: State<String> = _time

    fun setTitle(title: String){
        _title.value = title
    }

    fun setDescription(description: String){
        _description.value = description
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