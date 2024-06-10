package com.example.diplomaprojectclientapp.data.model

import com.google.gson.annotations.SerializedName


data class AuthRequest(
//    @SerializedName("grant_type") val grant_type: String? = "",
//    @SerializedName("username") val username: String,
//    @SerializedName("password") val password: String,
//    @SerializedName("scope") val scope: String? = "",
//    @SerializedName("client_id") val client_id: String? = "",
//    @SerializedName("client_secret") val client_secret: String? = ""

    val grant_type: String? = null,
    val username: String,
    val password: String,
    val scope: String? = null,
    val client_id: String? = null,
    val client_secret: String? = null
)
//
//data class RegisterRequest(
//    @SerializedName("email") val email: String,
//    @SerializedName("password") val password: String,
//    @SerializedName("is_active") val is_active: Boolean,
//    @SerializedName("is_superuser") val is_superuser: Boolean,
//    @SerializedName("is_verified") val is_verified: Boolean,
//    @SerializedName("user_status") val user_status: String
//)

data class RegisterRequest(
    val email: String,
    val password: String,
    val is_active: Boolean = true,
    val is_superuser: Boolean = false,
    val is_verified: Boolean = false,
    val user_status: String = "client"
)
