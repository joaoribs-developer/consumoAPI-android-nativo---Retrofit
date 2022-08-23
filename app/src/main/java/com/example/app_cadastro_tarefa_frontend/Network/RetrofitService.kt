package com.example.app_cadastro_tarefa_frontend.Network

import com.example.app_cadastro_tarefa_frontend.models.LoginRequest
import com.example.app_cadastro_tarefa_frontend.models.LoginResponse
import com.example.app_cadastro_tarefa_frontend.models.Tarefa
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService{
    @POST("api/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("api/tarefas")
    fun fetchPosts(@Header("Authorization") token: String): Call<List<Tarefa>>
}