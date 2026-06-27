package com.siefb.app.data

import android.content.Context
import com.siefb.app.data.database.DatabaseProvider
import com.siefb.app.data.repository.*
import com.siefb.app.data.repository.RegistroContableRepository
import com.siefb.app.data.repository.JugadorEntrenamientoRepository
import com.siefb.app.data.repository.JugadorPartidoRepository

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

    val jugadorPartidoRepository =
        JugadorPartidoRepository(
            database.jugadorPartidoDao()
        )


}