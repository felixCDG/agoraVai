package br.senai.sp.jandira.projetointegrado.model

import com.google.gson.annotations.SerializedName

data class PetRegister(
    var id: Int = 0,
    var nome: String = "",
    @SerializedName("data_nascimento") var dataNascimento: String = "",
    var foto: String = "",
    var necessidades: String = "",
    @SerializedName("id_endereco") var idEndereco: Int = 0,
    @SerializedName("id_porte") var idPorte: Int = 0,
    @SerializedName("id_status") var idStatus: Int = 0,
    @SerializedName("id_raca") var idRaca: Int = 0,
    @SerializedName("id_sexo") var idSexo: Int = 0,
    @SerializedName("id_temperamento") var idTemperamento: Int = 0,
    @SerializedName("id_especie") var idEspecie: Int = 0,
    var comportamento: List<ComportamentoItem> = emptyList(),
    var saude: List<SaudeItem> = emptyList()
)

data class ComportamentoItem(
    val comportamento: Int
)

data class SaudeItem(
    val saude: Int
)