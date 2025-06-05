package br.senai.sp.jandira.projetointegrado.service

import br.senai.sp.jandira.projetointegrado.model.ResultPet
import retrofit2.http.GET

interface PetService {

    @GET("pet")
    fun listAll(): retrofit2.Call<ResultPet>

}