package org.student.travelnoteapp.data.remote.services

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import org.student.travelnoteapp.data.remote.models.requests.RegistrationRequest

interface RegistrationService {

    suspend fun register(registrationRequest: RegistrationRequest): String?

    companion object {
        fun create(): RegistrationService {
            return RegistrationServiceImpl(
                client = HttpClient(Android) {
                    install(JsonFeature) {
                        serializer = KotlinxSerializer()
                    }
                }
            )
        }
    }
}