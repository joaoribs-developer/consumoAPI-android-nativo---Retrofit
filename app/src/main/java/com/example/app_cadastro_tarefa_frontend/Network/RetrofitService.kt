package com.example.app_cadastro_tarefa_frontend.Network

import com.example.app_cadastro_tarefa_frontend.models.*
import retrofit2.Call
import retrofit2.http.*

interface RetrofitService{
    @POST("api/login")
    fun login(@Body request: LoginRequest): Call<LoginResponse>

    @GET("api/tarefas")
    fun getTasks(): Call<List<Tarefa>>

    @POST("api/cadastro")
    fun addUser(@Body request: UserRequest): Call<UserResponse>
}