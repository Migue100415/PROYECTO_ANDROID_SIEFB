package com.siefb.app.data

import android.content.Context
import com.siefb.app.data.database.DatabaseProvider
import com.siefb.app.data.repository.*

class AppContainer(context: Context) {

    private val database =
        DatabaseProvider.getDatabase(context)

    val personaRepository =
        PersonaRepository(database.personaDao())

    val jugadorRepository =
        JugadorRepository(database.jugadorDao())

    val trabajadorRepository =
        TrabajadorRepository(database.trabajadorDao())

    val administradorRepository =
        AdministradorRepository(database.administradorDao())

    val profesionalDeportivoRepository =
        ProfesionalDeportivoRepository(
            database.profesionalDeportivoDao()
        )



    val partidoRepository =
        PartidoRepository(
            database.partidoDao()
        )

    val jugadorEntrenamientoRepository =
        JugadorEntrenamientoRepository(
            database.jugadorEntrenamientoDao()
        )

    val jugadorPartidoRepository =
        JugadorPartidoRepository(
            database.jugadorPartidoDao()
        )

    val registroContableRepository =
        RegistroContableRepository(
            database.registroContableDao()
        )
    val entrenamientoRepository =

        EntrenamientoRepository(

            database.entrenamientoDao()

        )


}