package com.siefb.app.data.repository

import com.siefb.app.data.dao.RegistroContableDao
import com.siefb.app.data.entities.RegistroContableEntity

class RegistroContableRepository(

    private val dao: RegistroContableDao

) {

    suspend fun insertar(
        registro: RegistroContableEntity
    ) =
        dao.insertar(registro)

    suspend fun actualizar(
        registro: RegistroContableEntity
    ) =
        dao.actualizar(registro)

    suspend fun eliminar(
        registro: RegistroContableEntity
    ) =
        dao.eliminar(registro)

    suspend fun obtenerPorId(
        id: Int
    ) =
        dao.obtenerPorId(id)

    fun obtenerTodos() =
        dao.obtenerTodos()

}