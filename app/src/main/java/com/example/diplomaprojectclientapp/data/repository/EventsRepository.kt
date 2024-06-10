package com.example.diplomaprojectclientapp.data.repository

import com.example.diplomaprojectclientapp.data.remote.ApiService
import com.example.diplomaprojectclientapp.viewmodel.Event

class EventsRepository(private val apiService: ApiService) {
    suspend fun getEvents(): List<Event> {
        // Mocking data. You should replace this with an actual network call
        return listOf(
            Event(1, "Event 1", "Description for event 1"),
            Event(2, "Event 2", "Description for event 2")
        )
    }
}