package com.siefb.app.data.repository

import com.siefb.app.data.dao.TrabajadorDao
import com.siefb.app.data.entities.TrabajadorEntity

class TrabajadorRepository(
    private val trabajadorDao: TrabajadorDao
) {

    fun obtenerTrabajadoresCompletos() =
        trabajadorDao.obtenerTrabajadoresCompletos()

    suspend fun obtenerPorId(id: Int) =
        trabajadorDao.obtenerPorId(id)

    suspend fun insertar(
        trabajador: TrabajadorEntity
    ) = trabajadorDao.insertar(trabajador)

    suspend fun actualizar(
        trabajador: TrabajadorEntity
    ) = trabajadorDao.actualizar(trabajador)

    suspend fun eliminar(
        trabajador: TrabajadorEntity
    ) = trabajadorDao.eliminar(trabajador)
}