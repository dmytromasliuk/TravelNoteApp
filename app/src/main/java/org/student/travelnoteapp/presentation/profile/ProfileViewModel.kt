package org.student.travelnoteapp.presentation.profile

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {

    private val _firstNameText = mutableStateOf("John")
    val firstNameText : State<String> = _firstNameText

    private val _lastNameText = mutableStateOf("Johnson")
    val lastNameText : State<String> = _lastNameText

    private val _name = mutableStateOf("${_firstNameText.value} ${_lastNameText.value}")
    val name: State<String> = _name

    private val _gender = mutableStateOf("male")
    val gender : State<String> = _gender

    private val _age = mutableStateOf("21")
    val age : State<String> = _age

    private val _emailText = mutableStateOf("jj@example.com")
    val emailText : State<String> = _emailText

    private val _phoneText = mutableStateOf("123 456 678")
    val phoneText : State<String> = _phoneText

    private val _countryText = mutableStateOf("Example")
    val countryText : State<String> = _countryText

    fun setFirstNameText(firstName : String){
        _firstNameText.value = firstName
    }

    fun setLastNameText(lastName : String){
        _lastNameText.value = lastName
    }

    fun setGenderText(gender: String){
        _gender.value = gender
    }

    fun setAgeText(age: String){
        _age.value = age
    }

    fun setEmailText(email : String){
        _emailText.value = email
    }

    fun setPhoneText(phone : String){
        _phoneText.value = phone
    }

    fun setCountryText(country : String){
        _countryText.value = country
    }
}