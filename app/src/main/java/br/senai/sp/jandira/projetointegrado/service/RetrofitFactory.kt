package br.senai.sp.jandira.foodrecipe.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val BASE_URL = "http://10.0.2.2:8080/v1/controle-pet/"

    private val RETROFIT_FACTORY = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUserRegisterService() : UserRegisterService{
        return RETROFIT_FACTORY
            .create(UserRegisterService::class.java)
    }
}