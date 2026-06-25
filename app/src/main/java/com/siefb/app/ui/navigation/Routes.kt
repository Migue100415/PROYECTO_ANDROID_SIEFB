package com.siefb.app.ui.navigation

sealed class Routes(val route: String) {

    data object Home : Routes("home")

    data object Jugadores : Routes("jugadores")

    data object JugadorForm : Routes("jugador_form/{jugadorId}") {

        fun createRoute(jugadorId: Int = -1): String {
            return "jugador_form/$jugadorId"
        }
    }
}