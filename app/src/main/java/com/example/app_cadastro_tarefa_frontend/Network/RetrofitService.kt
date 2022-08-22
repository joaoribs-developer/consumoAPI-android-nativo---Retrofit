package com.example.app_cadastro_tarefa_frontend.Network

import com.example.app_cadastro_tarefa_frontend.models.LoginRequest
import com.example.app_cadastro_tarefa_frontend.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface RetrofitService{
    @POST("api/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>
}