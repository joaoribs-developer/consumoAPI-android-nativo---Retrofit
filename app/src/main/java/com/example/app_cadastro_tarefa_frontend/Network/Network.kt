package com.example.app_cadastro_tarefa_frontend.Network

import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object{
        fun getRetrofitInstance(path : String): Retrofit{
            return Retrofit.Builder()
                .baseUrl(path)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}