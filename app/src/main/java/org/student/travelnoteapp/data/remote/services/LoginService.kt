package org.student.travelnoteapp.data.remote.services

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.*
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import org.student.travelnoteapp.data.remote.models.responses.ProfileResponse

interface LoginService {

    suspend fun login(): ProfileResponse?

    companion object {
        fun create(email: String, password: String): LoginService {
            return LoginServiceImpl(
                client = HttpClient(Android) {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                    install(HttpTimeout){
                        requestTimeoutMillis = 15000L
                        connectTimeoutMillis = 15000L
                        socketTimeoutMillis = 15000L
                    }
                    install(Auth){
                        basic {
                            credentials {
                                BasicAuthCredentials(email, password)
                            }
                            sendWithoutRequest { true }
                        }
                    }
                }
            )
        }
    }
}