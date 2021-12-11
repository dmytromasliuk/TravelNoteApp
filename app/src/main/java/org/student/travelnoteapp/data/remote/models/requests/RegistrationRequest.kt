package org.student.travelnoteapp.data.remote.models.requests

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationRequest(
    var firstName : String,
    var lastName : String,
    var email : String,
    var password : String
)
