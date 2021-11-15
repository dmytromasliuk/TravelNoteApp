package org.student.travelnoteapp.data.remote.services

import io.ktor.client.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.student.travelnoteapp.data.remote.HttpRoutes
import org.student.travelnoteapp.data.remote.models.requests.RegistrationRequest

class RegistrationServiceImplementation(
    private val client : HttpClient
) : RegistrationService {

    override suspend fun register(registrationRequest: RegistrationRequest): String? {
        return try {
            client.post<String>{
                url(HttpRoutes.REGISTRATION)
                contentType(ContentType.Application.Json)
                body = registrationRequest
            }
        } catch (e : Exception) {
            println("Error: ${e.message}")
            null
        }
    }
}