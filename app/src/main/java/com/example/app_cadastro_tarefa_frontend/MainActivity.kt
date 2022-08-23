package com.example.app_cadastro_tarefa_frontend

import android.net.Network
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.example.app_cadastro_tarefa_frontend.Network.ApiClient
import com.example.app_cadastro_tarefa_frontend.Network.RetrofitService
import com.example.app_cadastro_tarefa_frontend.Network.SessionManager
import com.example.app_cadastro_tarefa_frontend.models.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.create
import java.net.HttpURLConnection

class MainActivity : AppCompatActivity() {


    private lateinit var sessionManager: SessionManager
    private lateinit var apiClient: ApiClient
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button = findViewById<Button>(R.id.button).setOnClickListener {
            register()
//            fetchPosts()
        }
        logon()


    }

    private fun fetchPosts() {
        apiClient = ApiClient()
        // Pass the token as parameter
        apiClient.getRetrofitService(this).getTasks()
            .enqueue(object : Callback<List<Tarefa>> {
                override fun onResponse(
                    call: Call<List<Tarefa>>,
                    response: Response<List<Tarefa>>
                ) {
                    val response = response.body()
                    println(response)
                }

                override fun onFailure(call: Call<List<Tarefa>>, t: Throwable) {
                    println("fail")
                }
            })
    }

    fun register() {
        apiClient = ApiClient()
        apiClient.getRetrofitService(this)
            .addUser(UserRequest("TH Ghandes", "ghandes@email.com", "ghandes.senha"))
            .enqueue(object :Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.code() == 200)
                    println(response.body())
                    else
                        println("usuário ja cadastrado")
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    println("falhou")
                }
            })

    }

    fun logon() {

        apiClient = ApiClient()
        sessionManager = SessionManager(this)
        apiClient.getRetrofitService(this)
            .login(LoginRequest(login = "joao@email.com", senha = "joao.senha"))
            .enqueue(object : Callback<LoginResponse> {
                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {

                    val loginResponse = response.body()
                    println(loginResponse)
                    println(response.code())
                    if (response.code() == HttpURLConnection.HTTP_OK
                        && !loginResponse?.email.isNullOrEmpty()
                        && !loginResponse?.nome.isNullOrEmpty()
                    ) {
                        sessionManager.saveAuthToken(loginResponse!!.token)

                        var text = findViewById<TextView>(R.id.textView).setText(loginResponse.nome)

                    } else {
                        println("erro no login")
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