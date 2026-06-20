package com.siefb.app.data.repository

import com.siefb.app.data.dao.ProfesionalDeportivoDao
import com.siefb.app.data.entities.ProfesionalDeportivoEntity

class ProfesionalDeportivoRepository(
    private val profesionalDao: ProfesionalDeportivoDao
) {

    fun obtenerTodos() =
        profesionalDao.obtenerTodos()

    suspend fun obtenerPorId(id: Int) =
        profesionalDao.obtenerPorId(id)

    suspend fun insertar(
        profesional: ProfesionalDeportivoEntity
    ) = profesionalDao.insertar(profesional)

    suspend fun eliminar(
        profesional: ProfesionalDeportivoEntity
    ) = profesionalDao.eliminar(profesional)
}