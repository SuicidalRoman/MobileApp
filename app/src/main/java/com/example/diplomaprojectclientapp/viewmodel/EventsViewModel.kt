package com.example.diplomaprojectclientapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplomaprojectclientapp.data.repository.EventsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EventsViewModel(private val eventsRepository: EventsRepository) : ViewModel() {

    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>> = _events

    init {
        getEvents()
    }

    private fun getEvents() {
        viewModelScope.launch {
            _events.value = eventsRepository.getEvents()
        }
    }
}

data class Event(
    val id: Int,
    val title: String,
    val description: String
)