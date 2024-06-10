package com.example.diplomaprojectclientapp.data.remote



import com.example.diplomaprojectclientapp.data.model.AuthRequest
import com.example.diplomaprojectclientapp.data.model.Profile
import com.example.diplomaprojectclientapp.data.model.RegisterRequest
import com.example.diplomaprojectclientapp.data.model.ResponseUser
import com.example.diplomaprojectclientapp.data.model.Users

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {
    @FormUrlEncoded
    @POST("auth/jwt/login")
    suspend fun auth(
        @Field("grant_type") grant_type: String? = "",
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("scope") scope: String? = "",
        @Field("client_id") client_id: String? = "",
        @Field("client_secret") client_secret: String? = ""
    ): Response<Unit>

//    @FormUrlEncoded
//    @POST("auth/register")
//    suspend fun register(
//        @Field("email") email: String,
//        @Field("password") password: String,
//        @Field("is_active") is_active: Boolean = true,
//        @Field("is_superuser") is_superuser: Boolean = false,
//        @Field("is_verified") is_verified: Boolean = false,
//        @Field("user_status") user_status: String = "client"
//    ): Response<Unit>

    @POST("auth/register")
    suspend fun register(@Body registerRequest: RegisterRequest): Response<Unit>

    @FormUrlEncoded
    @GET("me/profile")
    suspend fun getMyProfile(): Response<Profile>
}
