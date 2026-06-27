package com.siefb.app.viewmodel.jugadorpartido

import com.siefb.app.data.entities.JugadorPartidoEntity

data class JugadorPartidoUiState(

    val registros:
    List<JugadorPartidoEntity> =
        emptyList(),

    val registroSeleccionado:
    JugadorPartidoEntity? = null,

    val isLoading: Boolean = false,

    val error: String? = null

)