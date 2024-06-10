package com.example.diplomaprojectclientapp.data.repository

import com.example.diplomaprojectclientapp.data.remote.ApiService


class ProfileRepository(private val apiService: ApiService) {
    suspend fun getMyProfile(token: String) = apiService.getMyProfile()
}