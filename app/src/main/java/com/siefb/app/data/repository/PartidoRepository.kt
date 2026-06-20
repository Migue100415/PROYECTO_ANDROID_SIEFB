package com.siefb.app.data.repository

import com.siefb.app.data.dao.PartidoDao
import com.siefb.app.data.entities.PartidoEntity

class PartidoRepository(
    private val partidoDao: PartidoDao
) {

    fun obtenerTodos() =
        partidoDao.obtenerTodos()

    suspend fun insertar(
        partido: PartidoEntity
    ): Long = partidoDao.insertar(partido)

    suspend fun actualizar(
        partido: PartidoEntity
    ) = partidoDao.actualizar(partido)

    suspend fun eliminar(
        partido: PartidoEntity
    ) = partidoDao.eliminar(partido)
}