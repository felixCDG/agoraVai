package br.senai.sp.jandira.foodrecipe.service


import br.senai.sp.jandira.foodrecipe.model.UserRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface UserRegisterService {

    @Headers("Content-Type: application/json")
    @POST("usuario")
    fun insertUser(@Body user: UserRegister): retrofit2.Call<UserRegister>

}