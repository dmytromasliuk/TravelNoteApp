package org.student.travelnoteapp.presentation.registration

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.student.travelnoteapp.data.remote.models.requests.RegistrationRequest
import org.student.travelnoteapp.data.remote.services.RegistrationService
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor() : ViewModel() {

    private val service by lazy {
        RegistrationService.create()
    }
    private val _firstNameText = mutableStateOf("")
    val firstNameText : State<String> = _firstNameText

    private val _lastNameText = mutableStateOf("")
    val lastNameText : State<String> = _lastNameText

    private val _emailText = mutableStateOf("")
    val emailText : State<String> = _emailText

    private val _passwordText = mutableStateOf("")
    val passwordText : State<String> = _passwordText

    fun setFirstNameText(firstName : String){
        _firstNameText.value = firstName
    }

    fun setLastNameText(lastName : String){
        _lastNameText.value = lastName
    }

    fun setEmailText(email : String){
        _emailText.value = email
    }

    fun setPasswordText(password : String){
        _passwordText.value = password
    }

    fun register() {
        viewModelScope.launch(Dispatchers.Main) {
            val request = RegistrationRequest(
                _firstNameText.value,
                _lastNameText.value,
                _emailText.value,
                _passwordText.value
            )
            service.register(request)
        }
    }
}