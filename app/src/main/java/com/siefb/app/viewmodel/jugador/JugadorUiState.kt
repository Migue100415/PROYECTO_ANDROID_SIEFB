package com.siefb.app.viewmodel.jugador

import com.siefb.app.data.relations.PersonaConJugador

data class JugadorUiState(

    val jugadores: List<PersonaConJugador> = emptyList(),

    val jugadorSeleccionado: PersonaConJugador? = null,

    val isLoading: Boolean = false,

    val error: String? = null
)