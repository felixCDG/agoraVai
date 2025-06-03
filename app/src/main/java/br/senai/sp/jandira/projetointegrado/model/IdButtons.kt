package br.senai.sp.jandira.projetointegrado.model

import androidx.compose.runtime.MutableState

data class IdButtons(
    val id: Int,
    val label: String,
    val isSelected: MutableState<Boolean>
)
