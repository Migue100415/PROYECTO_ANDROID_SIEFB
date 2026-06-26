package com.siefb.app.viewmodel.partido


import com.siefb.app.data.entities.PartidoEntity

data class PartidoUiState(

    val partidos:
    List<PartidoEntity> = emptyList(),

    val partidoSeleccionado:
    PartidoEntity? = null,

    val isLoading: Boolean = false,

    val error: String? = null

)