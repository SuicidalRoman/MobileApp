package com.example.diplomaprojectclientapp.data.model

import com.google.gson.annotations.SerializedName

data class Registrations(
    @SerializedName("id") val id: Int,
    @SerializedName("user_id") val userId: Int,
    @SerializedName("surname") val surname: String,
    @SerializedName("firstname") val firstname: String,
    @SerializedName("patronymic") val patronymic: String,
    @SerializedName("birthdate") val birthdate: String,
    @SerializedName("phone") val phone: String
)