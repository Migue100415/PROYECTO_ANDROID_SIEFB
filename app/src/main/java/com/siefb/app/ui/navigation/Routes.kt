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

    data object Partidos :
        Routes("partido")

    data object PartidoForm :
        Routes("partido_form/{partidoId}") {

        fun createRoute(
            partidoId: Int = -1
        ) =
            "partido_form/$partidoId"

    }

    data object RegistrosContables :
        Routes("registros_contables")

    data object RegistroContableForm :
        Routes("registro_contable_form/{registroId}") {

        fun createRoute(
            registroId: Int = -1
        ) =
            "registro_contable_form/$registroId"

    }

    data object JugadoresEntrenamiento :
        Routes("jugadores_entrenamiento")

    data object JugadorEntrenamientoForm :
        Routes("jugador_entrenamiento_form/{registroId}") {

        fun createRoute(
            registroId: Int = -1
        ) =
            "jugador_entrenamiento_form/$registroId"

    }
    data object JugadoresPartido :
        Routes("jugadores_partido")

    data object JugadorPartidoForm :
        Routes("jugador_partido_form/{registroId}") {

        fun createRoute(
            registroId: Int = -1
        ) =
            "jugador_partido_form/$registroId"

    }


}