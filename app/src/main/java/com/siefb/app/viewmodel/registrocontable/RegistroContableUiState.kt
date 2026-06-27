package com.siefb.app.viewmodel.registrocontable

import com.siefb.app.data.entities.RegistroContableEntity

data class RegistroContableUiState(

    val registros:
    List<RegistroContableEntity> =
        emptyList(),

    val registroSeleccionado:
    RegistroContableEntity? = null,

    val isLoading: Boolean = false,

    val error: String? = null

)