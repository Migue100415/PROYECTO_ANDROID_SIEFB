package com.siefb.app.ui.navigation

sealed class Routes(val route: String) {

    data object Home : Routes("home")

    data object Jugadores : Routes("jugadores")

    data object NuevoJugador : Routes("nuevo_jugador")
}