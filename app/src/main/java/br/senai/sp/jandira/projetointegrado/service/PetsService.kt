package br.senai.sp.jandira.projetointegrado.service

import android.telecom.Call
import br.senai.sp.jandira.projetointegrado.model.Pets
import br.senai.sp.jandira.projetointegrado.model.ResultPet
import retrofit2.http.GET
import retrofit2.http.Headers

interface PetsService {

    @Headers("Content-Type: application/json")
    @GET("pet")
    fun listAll(): retrofit2.Call<ResultPet>


}