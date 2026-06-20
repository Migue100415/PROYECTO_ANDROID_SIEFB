package com.siefb.app.data.repository

import com.siefb.app.data.dao.JugadorPartidoDao
import com.siefb.app.data.entities.JugadorPartidoEntity

class JugadorPartidoRepository(
    private val dao: JugadorPartidoDao
) {

    suspend fun insertar(
        registro: JugadorPartidoEntity
    ) = dao.insertar(registro)

    suspend fun obtenerPorPartido(
        partidoId: Int
    ) = dao.obtenerPorPartido(partidoId)
}