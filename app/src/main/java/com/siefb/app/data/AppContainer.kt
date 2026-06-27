package com.siefb.app.data

import android.content.Context
import com.siefb.app.data.database.DatabaseProvider
import com.siefb.app.data.repository.*
import com.siefb.app.data.repository.RegistroContableRepository
import com.siefb.app.data.repository.JugadorEntrenamientoRepository

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


    val jugadorPartidoRepository =
        JugadorPartidoRepository(
            database.jugadorPartidoDao()
        )

    val entrenamientoRepository =

        EntrenamientoRepository(

            database.entrenamientoDao()

        )
    val registroContableRepository =
        RegistroContableRepository(
            database.registroContableDao()
        )

    val jugadorEntrenamientoRepository =
        JugadorEntrenamientoRepository(
            database.jugadorEntrenamientoDao()
        )



}