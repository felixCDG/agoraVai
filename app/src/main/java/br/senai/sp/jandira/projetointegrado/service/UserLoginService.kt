package br.senai.sp.jandira.projetointegrado.service

import br.senai.sp.jandira.foodrecipe.model.UserRegister
import br.senai.sp.jandira.projetointegrado.model.UserLogin
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserLoginService {

    @Headers("Content-Type: application/json")
    @POST("login")
    fun loginUser(@Body user: UserLogin): retrofit2.Call<UserLogin>

}