package org.student.travelnoteapp.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.student.travelnoteapp.data.remote.models.responses.ProfileResponse
import org.student.travelnoteapp.data.remote.services.LoginService
import org.student.travelnoteapp.data.remote.services.RegistrationService
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor() : ViewModel() {

    private val service by lazy {
        LoginService.create(
            email = emailText.value,
            password = passwordText.value
        )
    }

    private var profileResponse: ProfileResponse? = null

    private val _emailText = mutableStateOf("")
    val emailText : State<String> = _emailText

    private val _passwordText = mutableStateOf("")
    val passwordText : State<String> = _passwordText

    fun setEmailText(email : String){
        _emailText.value = email
    }

    fun setPasswordText(password : String){
        _passwordText.value = password
    }

    fun getProfileResponse(): ProfileResponse?{
        return profileResponse
    }

    fun login(): ProfileResponse?{
        viewModelScope.launch(Dispatchers.Main) {
            profileResponse = service.login()
        }
        return profileResponse
    }
}