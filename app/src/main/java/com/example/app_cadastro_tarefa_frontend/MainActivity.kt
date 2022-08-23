package com.example.app_cadastro_tarefa_frontend

import android.net.Network
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app_cadastro_tarefa_frontend.Network.ApiClient
import com.example.app_cadastro_tarefa_frontend.Network.RetrofitService
import com.example.app_cadastro_tarefa_frontend.Network.SessionManager
import com.example.app_cadastro_tarefa_frontend.models.LoginRequest
import com.example.app_cadastro_tarefa_frontend.models.LoginResponse
import com.example.app_cadastro_tarefa_frontend.models.Tarefa
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
        //logon()
        fetchPosts()






    }
    private fun fetchPosts() {
        apiClient = ApiClient()
        // Pass the token as parameter
        apiClient.getRetrofitService(this).fetchPosts(token = "Bearer ${sessionManager.fetchAuthToken()}")
            .enqueue(object : Callback<List<Tarefa>> {
                override fun onFailure(call: Call<List<Tarefa>>, t: Throwable) {
                    // Error fetching posts
                }

                override fun onResponse(call: Call<List<Tarefa>>, response: Response<List<Tarefa>>) {
                    val response = response.body()
                    println(response)
                }
            })
    }
    fun logon(){

        apiClient = ApiClient()
        sessionManager = SessionManager(this)
        apiClient.getRetrofitService(this)
            .login(LoginRequest(login = "fiona230@gmail.com", senha = "glayconsenha"))
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val loginResponse = response.body()
                    println(loginResponse)
                    if (loginResponse?.email.isNullOrEmpty()
                        && loginResponse?.nome.isNullOrEmpty()) {
                        sessionManager.saveAuthToken(loginResponse!!.token)
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
/*
fun login(){
        val client = com.example.app_cadastro_tarefa_frontend.Network.
        Network.getRetrofitInstance("http://10.0.2.2:8080/")
        val endpoints = client.create<Endpoints>(Endpoints::class.java)
        endpoints.getLogin(LoginRequest(login = "fiona230@gmail.com", senha = "glayconsenha"))
            .enqueue(object : Callback<LoginResponse>{
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    val response = response.body()
                    println(response)
                    println(response.)
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    println("fail")
                }
            })
    }
 */