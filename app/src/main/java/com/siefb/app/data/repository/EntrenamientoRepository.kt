package com.siefb.app.data.repository

import com.siefb.app.data.dao.EntrenamientoDao
import com.siefb.app.data.entities.EntrenamientoEntity

class EntrenamientoRepository(
    private val entrenamientoDao: EntrenamientoDao
) {

    fun obtenerTodos() =
        entrenamientoDao.obtenerTodos()

    suspend fun insertar(
        entrenamiento: EntrenamientoEntity
    ): Long = entrenamientoDao.insertar(entrenamiento)

    suspend fun actualizar(
        entrenamiento: EntrenamientoEntity
    ) = entrenamientoDao.actualizar(entrenamiento)

    suspend fun eliminar(
        entrenamiento: EntrenamientoEntity
    ) = entrenamientoDao.eliminar(entrenamiento)
}