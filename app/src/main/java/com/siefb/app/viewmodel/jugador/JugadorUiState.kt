package com.siefb.app.viewmodel.jugador

import com.siefb.app.data.entities.JugadorEntity

data class JugadorUiState(

    val jugadores: List<JugadorEntity> = emptyList(),

    val isLoading: Boolean = false,

    val error: String? = null
)