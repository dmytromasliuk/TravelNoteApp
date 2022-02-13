package org.student.travelnoteapp.data.remote.services

import io.ktor.client.*
import io.ktor.client.features.*
import io.ktor.client.request.*
import io.ktor.http.*
import org.student.travelnoteapp.data.remote.HttpRoutes
import org.student.travelnoteapp.data.remote.models.requests.LoginRequest
import org.student.travelnoteapp.data.remote.models.responses.ProfileResponse

class LoginServiceImpl(
    private val client: HttpClient,
) : LoginService {

    override suspend fun login(): ProfileResponse? {
        return try {
            client.get{
                url(HttpRoutes.LOGIN)
                contentType(ContentType.Application.Json)
            }
        } catch (ex: RedirectResponseException) {
            // 3xx - responses
            println("Error 3xx: ${ex.response.status.description}")
            null
        } catch (ex: ClientRequestException) {
            // 4xx - responses
            println("Error 4xx: ${ex.response.status.description}")
            null
        } catch (ex: ServerResponseException) {
            // 5xx - response
            println("Error 5xx: ${ex.response.status.description}")
            null
        }
    }

}
