package com.example.app_cadastro_tarefa_frontend.models

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("nome")
    val nome: String,
    @SerializedName("login")
    val login :String,
    @SerializedName("senha")
    var senha :String,
)
