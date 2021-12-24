package org.student.travelnoteapp.data.remote.services

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import org.student.travelnoteapp.data.remote.models.requests.LoginRequest
import org.student.travelnoteapp.data.remote.models.requests.RegistrationRequest

interface LoginService {

    val email: String
    val password: String

    suspend fun login(loginRequest: LoginRequest): String?

    fun setEmail(email: String)
    fun setPassword(password: String)

    companion object {
        fun create(): LoginService {
            return LoginServiceImpl(
                client = HttpClient(Android) {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                    install(Auth) {
                        basic {
                            credentials {
                                BasicAuthCredentials(
                                    username =
                                )
                            }
                        }
                    }
                }
            )
        }
    }
}