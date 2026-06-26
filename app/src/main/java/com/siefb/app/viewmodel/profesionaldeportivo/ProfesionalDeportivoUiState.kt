package com.siefb.app.viewmodel.profesionaldeportivo

import com.siefb.app.data.relations
.PersonaProfesionalDeportivo

data class ProfesionalDeportivoUiState(

    val profesionales:
    List<PersonaProfesionalDeportivo> =
        emptyList(),

    val profesionalSeleccionado:
    PersonaProfesionalDeportivo? = null,

    val isLoading: Boolean = false,

    val error: String? = null
)