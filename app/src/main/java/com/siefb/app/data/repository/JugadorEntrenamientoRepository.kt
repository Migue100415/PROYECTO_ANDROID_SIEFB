package com.siefb.app.data.repository

import com.siefb.app.data.dao.JugadorEntrenamientoDao
import com.siefb.app.data.entities.JugadorEntrenamientoEntity

class JugadorEntrenamientoRepository(

    private val dao: JugadorEntrenamientoDao

) {

    suspend fun insertar(
        registro: JugadorEntrenamientoEntity
    ) =
        dao.insertar(registro)

    suspend fun actualizar(
        registro: JugadorEntrenamientoEntity
    ) =
        dao.actualizar(registro)

    suspend fun eliminar(
        registro: JugadorEntrenamientoEntity
    ) =
        dao.eliminar(registro)

    suspend fun obtenerPorId(
        id: Int
    ) =
        dao.obtenerPorId(id)

    fun obtenerTodos() =
        dao.obtenerTodos()

}