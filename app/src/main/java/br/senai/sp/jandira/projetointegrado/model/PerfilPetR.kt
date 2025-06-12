package br.senai.sp.jandira.projetointegrado.model

import com.google.gson.annotations.SerializedName

data class PerfilPetR(
    var id: Int = 0,
    var foto: String = "",
    var nome: String = "",
    @SerializedName("id_endereco") var idEndereco: Int = 0,
    var necessidades: String = "",
    @SerializedName("id_saude") var idSaude: Int = 0,
    @SerializedName("id_comportamento") var idComportamento: Int = 0,
)
