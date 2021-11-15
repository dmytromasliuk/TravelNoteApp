package org.student.travelnoteapp.data.remote.models.requests

import kotlinx.serialization.Serializable

@Serializable
data class RegistrationRequest(
    val firstName : String,
    val lastName : String,
    val email : String,
    val password : String
)
