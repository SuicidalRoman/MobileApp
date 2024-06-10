package com.example.diplomaprojectclientapp.viewmodel

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.diplomaprojectclientapp.data.model.Profile
import com.example.diplomaprojectclientapp.data.remote.RetrofitInstance
import com.example.diplomaprojectclientapp.data.repository.ProfileRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProfileViewModel(private val profileRepository: ProfileRepository) : ViewModel() {

    private val _profile = MutableStateFlow<Profile?>(null)
    val profile: StateFlow<Profile?> = _profile

    fun loadProfile() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getMyProfile()
                if (response.isSuccessful) {
                    _profile.value = response.body()
                } else {
                    Log.d("Profile", "Error: ${response.errorBody()?.string()}")
                }
            } catch (e: Exception) {
                Log.d("Profile", "$e")
            }
        }
    }

    fun updateProfilePhoto(photoPath: String) {
        // Implement the logic to update the profile photo
    }
}