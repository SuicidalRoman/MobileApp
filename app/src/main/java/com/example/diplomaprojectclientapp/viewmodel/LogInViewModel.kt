package com.example.diplomaprojectclientapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplomaprojectclientapp.data.remote.RetrofitInstance
import com.example.diplomaprojectclientapp.data.repository.AuthRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class LoginViewModel(private val authRepository: AuthRepository) : ViewModel() {

    private val _loginState = MutableStateFlow(false)
    val loginState: StateFlow<Boolean> = _loginState

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.auth(username = username, password = password)
                _loginState.value = response.isSuccessful && response.code() == 204
            } catch (e: Exception) {
                Log.d("Auth", "$e")
            }
        }
    }
}