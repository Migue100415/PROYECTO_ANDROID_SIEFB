package com.siefb.app.viewmodel.administrador

import com.siefb.app.data.relations.PersonaAdministrador

data class AdministradorUiState(

    val administradores:
    List<PersonaAdministrador> =
        emptyList(),

    val administradorSeleccionado:
    PersonaAdministrador? = null,

    val isLoading: Boolean = false,

    val error: String? = null
)