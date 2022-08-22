package com.example.app_cadastro_tarefa_frontend.Network

import android.content.Context
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class ApiClient() {
    val baseURL = "https://localhost:8080/"
    lateinit var retrofitService: RetrofitService

    fun getRetrofitService(context: Context): RetrofitService {
        if (!::retrofitService.isInitialized) {
             val retrofit = Retrofit.Builder()
                .baseUrl(baseURL)
                 .client(okhttpClient(context))
                .addConverterFactory(GsonConverterFactory.create())
                .build()
           retrofitService = retrofit.create(RetrofitService::class.java)

    }
        return retrofitService
    }

    private fun okhttpClient(context: Context): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(context))
            .build()
    }
}