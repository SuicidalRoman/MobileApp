package com.example.diplomaprojectclientapp.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplomaprojectclientapp.data.repository.HomeRepository
import com.example.diplomaprojectclientapp.data.repository.Request
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class HomeViewModel(private val homeRepository: HomeRepository) : ViewModel() {

    private val _requests = MutableStateFlow<List<Request>>(emptyList())
    val requests: StateFlow<List<Request>> = _requests

    init {
        getRequests()
    }

    private fun getRequests() {
        viewModelScope.launch {
            _requests.value = homeRepository.getRequests()
        }
    }
}