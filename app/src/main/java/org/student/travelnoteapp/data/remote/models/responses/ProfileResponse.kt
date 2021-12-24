package org.student.travelnoteapp.data.remote.models.responses

import kotlinx.serialization.Serializable

@Serializable
data class ProfileResponse(
    val firstName: String,
    val lastName: String,
    val email: String,
    val phone: String,
    val country: String
)
