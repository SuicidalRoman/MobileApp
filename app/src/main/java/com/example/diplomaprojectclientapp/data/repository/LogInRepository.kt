package com.example.diplomaprojectclientapp.data.repository

import com.example.diplomaprojectclientapp.data.model.RegisterRequest
import com.example.diplomaprojectclientapp.data.remote.ApiService
import retrofit2.Response

class AuthRepository(private val apiService: ApiService) {

    suspend fun login(username: String, password: String): Response<Unit> {
        return apiService.auth(
            grant_type = "",
            username = username,
            password = password,
            scope = "",
            client_id = "",
            client_secret = ""
        )
    }


}