package br.senai.sp.jandira.projetointegrado.service

import br.senai.sp.jandira.projetointegrado.model.PetRegister
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface PetRegisterService {
    @Headers("Content-Type: application/json")
    @POST("pet")
    fun cadastroPet(@Body pet: PetRegister): retrofit2.Call<PetRegister>
}