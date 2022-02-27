package org.student.travelnoteapp.presentation.login

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.student.travelnoteapp.data.remote.models.responses.ProfileResponse
import org.student.travelnoteapp.data.remote.services.LoginService
import org.student.travelnoteapp.data.room.model.Profile
import org.student.travelnoteapp.data.room.model.relations.ProfileAndTravel
import org.student.travelnoteapp.data.room.repository.ProfileRepository
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val profileRepository: ProfileRepository
) : ViewModel() {

    private val service by lazy {
        LoginService.create(
            email = emailText.value,
            password = passwordText.value
        )
    }

    private val _profileResponse = MutableLiveData<ProfileResponse>()
    val profileResponse: LiveData<ProfileResponse> = _profileResponse

    private val _emailText = mutableStateOf("")
    val emailText : State<String> = _emailText

    private val _passwordText = mutableStateOf("")
    val passwordText : State<String> = _passwordText

    private val _profile = MutableLiveData<ProfileAndTravel>()
    val profile: LiveData<ProfileAndTravel> = _profile


    fun setEmailText(email : String){
        _emailText.value = email
    }

    fun setPasswordText(password : String){
        _passwordText.value = password
    }

    fun getProfileByEmail(email: String): Profile?{
        return profileRepository.getProfileByEmail(email = email).value?.profile
    }

    fun createProfile(){
        viewModelScope.launch(Dispatchers.Main) {
            val profile = Profile(
                0,
                profileResponse.value?.firstName.toString(),
                profileResponse.value?.lastName.toString(),
                profileResponse.value?.email.toString(),
                profileResponse.value?.phone.toString(),
                profileResponse.value?.country.toString(),
            )
            profileRepository.createProfile(profile = profile)
        }
    }

    fun updateProfile(profile: Profile){
        viewModelScope.launch(Dispatchers.IO) {
            profileRepository.updateProfile(profile)
        }
    }

     suspend fun isExistsByEmail(email: String): Boolean = withContext(Dispatchers.IO){
         return@withContext profileRepository.isExistByEmail(email = email)
    }

    fun login(){
        viewModelScope.launch(Dispatchers.Main) {
            _profileResponse.value = service.login()
        }
    }

    /*fun getProfileIdByEmail(email: String): Long {
        return profileRepository.getProfileIdByEmail(email = email)
    }*/
}