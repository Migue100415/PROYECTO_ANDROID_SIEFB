package com.siefb.app.data.repository

import com.siefb.app.data.dao.RegistroContableDao
import com.siefb.app.data.entities.RegistroContableEntity

class RegistroContableRepository(
    private val registroContableDao: RegistroContableDao
) {

    fun obtenerTodos() =
        registroContableDao.obtenerTodos()

    suspend fun insertar(
        registro: RegistroContableEntity
    ) = registroContableDao.insertar(registro)

    suspend fun actualizar(
        registro: RegistroContableEntity
    ) = registroContableDao.actualizar(registro)

    suspend fun eliminar(
        registro: RegistroContableEntity
    ) = registroContableDao.eliminar(registro)
}