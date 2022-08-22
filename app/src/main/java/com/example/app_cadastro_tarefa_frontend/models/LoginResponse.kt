package com.example.app_cadastro_tarefa_frontend.models

import com.google.gson.annotations.SerializedName

data class LoginResponse(
@SerializedName("status_code")
var statusCode: Int,

@SerializedName("auth_token")
var authToken: String,

@SerializedName("nome")
val nome: String,
@SerializedName("email")
val email: String,
)

