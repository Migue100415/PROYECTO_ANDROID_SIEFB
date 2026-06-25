package com.siefb.app.viewmodel.trabajador

import com.siefb.app.data.relations.PersonaConTrabajador

data class TrabajadorUiState(

    val trabajadores: List<PersonaConTrabajador> = emptyList(),

    val trabajadorSeleccionado: PersonaConTrabajador? = null,

    val isLoading: Boolean = false,

    val error: String? = null
)