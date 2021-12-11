package org.student.travelnoteapp.presentation.registration

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor() : ViewModel() {

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
}