package com.example.app_cadastro_tarefa_frontend.models

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.gson.annotations.SerializedName
import org.threeten.bp.LocalDate
import org.threeten.bp.LocalDateTime;
import kotlin.coroutines.EmptyCoroutineContext.toString

data class Tarefa(
    @SerializedName("id")
    val id: Int,
    @SerializedName("nome")
    var nome: String,
    @SerializedName("prazo")
    var prazo: String,
    @SerializedName("cadastro")
    var cadastro: String,
    @SerializedName("descricao")
    var descricao: String,
    @SerializedName("users")
    val users: Users?
)
