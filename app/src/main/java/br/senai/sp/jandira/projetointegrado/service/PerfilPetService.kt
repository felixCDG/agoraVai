package br.senai.sp.jandira.projetointegrado.service

import br.senai.sp.jandira.projetointegrado.model.PerfilPetR
import br.senai.sp.jandira.projetointegrado.model.ResultPet
import retrofit2.http.GET
import retrofit2.http.Headers

interface PerfilPetService {

    @Headers("Content-Type: application/json")
    @GET("pet")
    fun listPetPerfil(): retrofit2.Call<PerfilPetR>

}