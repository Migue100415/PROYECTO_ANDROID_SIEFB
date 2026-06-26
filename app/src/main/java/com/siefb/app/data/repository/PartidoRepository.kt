package com.siefb.app.data.repository


import com.siefb.app.data.dao.PartidoDao
import com.siefb.app.data.entities.PartidoEntity

class PartidoRepository(

    private val partidoDao: PartidoDao

) {

    suspend fun insertar(
        partido: PartidoEntity
    ) =
        partidoDao.insertar(partido)

    suspend fun actualizar(
        partido: PartidoEntity
    ) =
        partidoDao.actualizar(partido)

    suspend fun eliminar(
        partido: PartidoEntity
    ) =
        partidoDao.eliminar(partido)

    suspend fun obtenerPorId(
        id: Int
    ) =
        partidoDao.obtenerPorId(id)

    fun obtenerTodos() =
        partidoDao.obtenerTodos()

}