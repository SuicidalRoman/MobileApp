package com.example.diplomaprojectclientapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplomaprojectclientapp.data.model.RegisterRequest
import com.example.diplomaprojectclientapp.data.remote.RetrofitInstance
import com.example.diplomaprojectclientapp.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RegisterViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _registerState = MutableStateFlow(false)
    val registerState: StateFlow<Boolean> = _registerState

    fun register(email: String, password: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.register(RegisterRequest(email = email, password = password))
                _registerState.value = response.isSuccessful && response.code() == 201
                if (!response.isSuccessful) {
                    Log.d("Register", "Error: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.d("Register", "$e")
            }
        }
    }
}