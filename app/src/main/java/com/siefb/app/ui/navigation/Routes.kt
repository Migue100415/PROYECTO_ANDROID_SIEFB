package com.siefb.app.ui.navigation

sealed class Routes(
    val route: String
) {

    data object Home :
        Routes("home")

    data object Jugadores :
        Routes("jugadores")

    data object JugadorForm :
        Routes("jugador_form/{jugadorId}") {

        fun createRoute(
            jugadorId: Int = -1
        ) =
            "jugador_form/$jugadorId"
    }

    data object Trabajadores :
        Routes("trabajadores")

    data object TrabajadorForm :
        Routes("trabajador_form/{trabajadorId}") {

        fun createRoute(
            trabajadorId: Int = -1
        ) =
            "trabajador_form/$trabajadorId"
    }

    data object Administradores :
        Routes("administradores")

    data object AdministradorForm :
        Routes("administrador_form")

    data object ProfesionalesDeportivos :
        Routes("profesionales_deportivos")

    data object ProfesionalDeportivoForm :
        Routes("profesional_deportivo_form")

    data object Entrenamientos :

        Routes("entrenamientos")

    data object EntrenamientoForm :

        Routes("entrenamiento_form/{entrenamientoId}") {

        fun createRoute(

            entrenamientoId: Int = -1

        ) =

            "entrenamiento_form/$entrenamientoId"

    }

}