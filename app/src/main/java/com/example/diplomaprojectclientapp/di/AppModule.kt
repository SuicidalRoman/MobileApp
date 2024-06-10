package com.example.diplomaprojectclientapp.di

import com.example.diplomaprojectclientapp.data.remote.ApiService
import com.example.diplomaprojectclientapp.data.repository.AuthRepository
import com.example.diplomaprojectclientapp.data.repository.HomeRepository
import com.example.diplomaprojectclientapp.data.repository.ProfileRepository
import com.example.diplomaprojectclientapp.viewmodel.HomeViewModel
import com.example.diplomaprojectclientapp.viewmodel.LoginViewModel
import com.example.diplomaprojectclientapp.viewmodel.ProfileViewModel
import com.example.diplomaprojectclientapp.viewmodel.RegisterViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.HostnameVerifier
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

val appModule = module {
    single {
        val trustAllCerts = arrayOf<TrustManager>(object : X509TrustManager {
            override fun checkClientTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
            override fun checkServerTrusted(chain: Array<out X509Certificate>?, authType: String?) {}
            override fun getAcceptedIssuers(): Array<X509Certificate> = arrayOf()
        })

        val sslContext = SSLContext.getInstance("SSL")
        sslContext.init(null, trustAllCerts, SecureRandom())
        val sslSocketFactory = sslContext.socketFactory

        val client = OkHttpClient.Builder()
            .sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            .hostnameVerifier(HostnameVerifier { _, _ -> true })
            .build()

        Retrofit.Builder()
            .baseUrl("http://10.0.2.2:8000/")
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
    single { AuthRepository(get()) }
    single { ProfileRepository(get()) }
    single { HomeRepository(get()) }
    viewModel { LoginViewModel(get()) }
    viewModel { ProfileViewModel(get()) }
    viewModel { RegisterViewModel(get()) }
    viewModel { HomeViewModel(get()) }
}