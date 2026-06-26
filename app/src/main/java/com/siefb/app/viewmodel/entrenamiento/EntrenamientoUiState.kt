package com.siefb.app.viewmodel.entrenamiento

import com.siefb.app.data.entities.EntrenamientoEntity

data class EntrenamientoUiState(

    val entrenamientos:
    List<EntrenamientoEntity> =
        emptyList(),

    val entrenamientoSeleccionado:
    EntrenamientoEntity? = null,

    val isLoading: Boolean = false,

    val error: String? = null
)