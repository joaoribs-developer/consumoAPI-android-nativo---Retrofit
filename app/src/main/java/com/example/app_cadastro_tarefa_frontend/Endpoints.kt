package com.example.app_cadastro_tarefa_frontend

import com.example.app_cadastro_tarefa_frontend.models.LoginRequest
import com.example.app_cadastro_tarefa_frontend.models.LoginResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface Endpoints {
    @POST("/api/login")
    fun getLogin(@Body request: LoginRequest): Call<JSONObject>
}