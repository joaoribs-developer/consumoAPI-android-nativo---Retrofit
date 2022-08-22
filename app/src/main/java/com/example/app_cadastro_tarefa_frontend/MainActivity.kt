package com.example.app_cadastro_tarefa_frontend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app_cadastro_tarefa_frontend.Network.ApiClient
import com.example.app_cadastro_tarefa_frontend.Network.Network
import com.example.app_cadastro_tarefa_frontend.Network.RetrofitService
import com.example.app_cadastro_tarefa_frontend.Network.SessionManager
import com.example.app_cadastro_tarefa_frontend.models.LoginRequest
import com.example.app_cadastro_tarefa_frontend.models.LoginResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create

class MainActivity : AppCompatActivity() {
    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiClient = ApiClient()
        sessionManager = SessionManager(this)
        apiClient.getRetrofitService(this)
            .login(LoginRequest(login = "Grandes23@email.com", senha = "ghandes.senha"))
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val loginResponse = response.body()
                    println(loginResponse)
                    if (loginResponse?.statusCode == 200
                        && loginResponse.email.isNullOrEmpty()
                        && loginResponse.nome.isNullOrEmpty()) {
                        sessionManager.saveAuthToken(loginResponse.authToken)
                    } else {
                        println("teste token 2")
                        // Error logging in
                    }

                }
                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    println("falhou")
                }
            }
            )
    }

}
