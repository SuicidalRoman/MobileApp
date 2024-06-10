package com.example.diplomaprojectclientapp.data.repository

import com.example.diplomaprojectclientapp.data.remote.ApiService

class HomeRepository(private val apiService: ApiService) {
    suspend fun getRequests(): List<Request> {
        // Mocking data. You should replace this with an actual network call
        return listOf(
            Request(1, "Request 1", "Description for request 1"),
            Request(2, "Request 2", "Description for request 2")
        )
    }
}

data class Request(
    val id: Int,
    val title: String,
    val description: String
)
