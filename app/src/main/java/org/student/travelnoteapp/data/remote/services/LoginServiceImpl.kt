package org.student.travelnoteapp.data.remote.services

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.student.travelnoteapp.data.remote.HttpRoutes
import org.student.travelnoteapp.data.remote.models.requests.LoginRequest

class LoginServiceImpl(
    private val client: HttpClient
) : LoginService {

    override suspend fun login(loginRequest: LoginRequest): String? {
        return try {
            client.post<String>{
                url(HttpRoutes.REGISTRATION)
                contentType(ContentType.Application.Json)
                body = loginRequest
            }
        } catch (ex: RedirectResponseException) {
            // 3xx - responses
            println("Error: ${ex.response.status.description}")
            null
        } catch (ex: ClientRequestException) {
            // 4xx - responses
            println("Error: ${ex.response.status.description}")
            null
        } catch (ex: ServerResponseException) {
            // 5xx - response
            println("Error: ${ex.response.status.description}")
            null
        }
    }

}
