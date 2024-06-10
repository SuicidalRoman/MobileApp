package com.example.diplomaprojectclientapp.data.model

import com.google.gson.annotations.SerializedName

enum class status(
    val admin: String = "admin",
    val client: String = "client"
)

data class Users(
    @SerializedName("id") val id: Int,
    @SerializedName("login") val login: String,
    @SerializedName("password") val password: String,
    @SerializedName("user_status") val user_status:  String,
    @SerializedName("registered_at") val registered_at: String,
    @SerializedName("updated_at") val updated_at: String,
    @SerializedName("is_active") val is_active: Boolean,
    @SerializedName("is_superuser") val is_superuser: Boolean,
    @SerializedName("is_verified") val is_verified: Boolean
)

data class ResponseUser(
    @SerializedName("id") val id: Int,
    @SerializedName("email") val email: String,
    @SerializedName("user_status") val user_status:  String,
    @SerializedName("is_active") val is_active: Boolean,
    @SerializedName("is_superuser") val is_superuser: Boolean,
    @SerializedName("is_verified") val is_verified: Boolean
)