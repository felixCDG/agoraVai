package br.senai.sp.jandira.foodrecipe.service

import br.senai.sp.jandira.projetointegrado.service.PetRegisterService
import br.senai.sp.jandira.projetointegrado.service.PetsService
import br.senai.sp.jandira.projetointegrado.service.UserLoginService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitFactory {

    private val BASE_URL = "http://10.0.2.2:3030/v1/controle-pet/"

    private val RETROFIT_FACTORY = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun getUserRegisterService() : UserRegisterService{
        return RETROFIT_FACTORY
            .create(UserRegisterService::class.java)
    }

    fun getUserLoginService() : UserLoginService{
        return RETROFIT_FACTORY
            .create(UserLoginService::class.java)
    }

    fun getPetRegisterService() : PetRegisterService{
        return RETROFIT_FACTORY
            .create(PetRegisterService::class.java)
    }

    fun getPetService() : PetsService{
        return RETROFIT_FACTORY
            .create(PetsService::class.java)
    }

    fun getPetPerfilService() : PetsService{
        return RETROFIT_FACTORY
            .create(PetsService::class.java)
    }

}