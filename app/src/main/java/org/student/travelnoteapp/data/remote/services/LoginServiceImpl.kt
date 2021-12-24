package org.student.travelnoteapp.data.remote.services

import io.ktor.client.*
import org.student.travelnoteapp.data.remote.models.requests.LoginRequest

class LoginServiceImpl(
    client: HttpClient
) : LoginService {
    override fun setEmail(email: String) {
        TODO("Not yet implemented")
    }

    override fun setPassword(password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun login(loginRequest: LoginRequest): String? {

    }
}
