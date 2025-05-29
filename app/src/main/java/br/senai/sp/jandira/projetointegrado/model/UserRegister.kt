package br.senai.sp.jandira.foodrecipe.model

import com.google.gson.annotations.SerializedName

data class UserRegister(
    var id: Int = 0,
    var nome: String = "",
    var email: String = "",
    var senha: String = "",
    var cpf: String = "",
    @SerializedName("palavra_chave") var palavraChave: String = "",
    var contato: String = "",
    @SerializedName("data_nascimento") var dataNascimento: String = "",
    @SerializedName("id_endereco") var idEndereco: Int = 0

)
