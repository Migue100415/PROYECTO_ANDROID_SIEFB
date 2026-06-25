package com.siefb.app.data.repository

import com.siefb.app.data.dao.JugadorDao
import com.siefb.app.data.entities.JugadorEntity

class JugadorRepository(
    private val jugadorDao: JugadorDao
) {

    fun obtenerJugadoresCompletos() = jugadorDao.obtenerJugadoresCompletos()

    suspend fun obtenerPorId(id: Int) =
        jugadorDao.obtenerPorId(id)

    suspend fun insertar(jugador: JugadorEntity) =
        jugadorDao.insertar(jugador)

    suspend fun actualizar(jugador: JugadorEntity) =
        jugadorDao.actualizar(jugador)

    suspend fun eliminar(jugador: JugadorEntity) =
        jugadorDao.eliminar(jugador)
}