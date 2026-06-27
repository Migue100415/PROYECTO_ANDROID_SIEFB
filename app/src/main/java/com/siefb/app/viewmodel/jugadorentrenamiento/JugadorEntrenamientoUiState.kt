package com.siefb.app.viewmodel.jugadorentrenamiento

import com.siefb.app.data.entities.JugadorEntrenamientoEntity

data class JugadorEntrenamientoUiState(

    val registros:
    List<JugadorEntrenamientoEntity> =
        emptyList(),

    val registroSeleccionado:
    JugadorEntrenamientoEntity? = null,

    val isLoading: Boolean = false,

    val error: String? = null

)