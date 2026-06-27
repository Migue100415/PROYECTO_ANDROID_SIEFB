package com.siefb.app.data.repository

import com.siefb.app.data.dao.JugadorPartidoDao
import com.siefb.app.data.entities.JugadorPartidoEntity

class JugadorPartidoRepository(

    private val dao: JugadorPartidoDao

) {

    suspend fun insertar(
        registro: JugadorPartidoEntity
    ) =
        dao.insertar(registro)

    suspend fun actualizar(
        registro: JugadorPartidoEntity
    ) =
        dao.actualizar(registro)

    suspend fun eliminar(
        registro: JugadorPartidoEntity
    ) =
        dao.eliminar(registro)

    suspend fun obtenerPorId(
        id: Int
    ) =
        dao.obtenerPorId(id)

    fun obtenerTodos() =
        dao.obtenerTodos()

}