package com.example.app_cadastro_tarefa_frontend.models

import com.google.gson.annotations.SerializedName

data class tarefaResponse(
    @SerializedName("tarefa")
    val tasks : List<Tarefa> = mutableListOf()
)
