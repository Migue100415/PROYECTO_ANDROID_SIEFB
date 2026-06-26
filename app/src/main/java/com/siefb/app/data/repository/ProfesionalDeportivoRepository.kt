package com.siefb.app.data.repository

import com.siefb.app.data.dao.ProfesionalDeportivoDao
import com.siefb.app.data.entities.ProfesionalDeportivoEntity

class ProfesionalDeportivoRepository(

    private val profesionalDeportivoDao:
    ProfesionalDeportivoDao

) {

    suspend fun insertar(
        profesionalDeportivo:
        ProfesionalDeportivoEntity
    ) =
        profesionalDeportivoDao.insertar(
            profesionalDeportivo
        )

    suspend fun eliminar(
        profesionalDeportivo:
        ProfesionalDeportivoEntity
    ) =
        profesionalDeportivoDao.eliminar(
            profesionalDeportivo
        )

    suspend fun obtenerPorId(
        id: Int
    ) =
        profesionalDeportivoDao.obtenerPorId(
            id
        )

    fun obtenerProfesionalesCompletos() =
        profesionalDeportivoDao
            .obtenerProfesionalesCompletos()
}