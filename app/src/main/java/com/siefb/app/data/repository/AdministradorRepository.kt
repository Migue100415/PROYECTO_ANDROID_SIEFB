package com.siefb.app.data.repository

import com.siefb.app.data.dao.AdministradorDao
import com.siefb.app.data.entities.AdministradorEntity

class AdministradorRepository(
    private val administradorDao: AdministradorDao
) {

    suspend fun insertar(
        administrador: AdministradorEntity
    ) =
        administradorDao.insertar(
            administrador
        )

    suspend fun eliminar(
        administrador: AdministradorEntity
    ) =
        administradorDao.eliminar(
            administrador
        )

    suspend fun obtenerPorId(
        id: Int
    ) =
        administradorDao.obtenerPorId(id)

    fun obtenerAdministradoresCompletos() =
        administradorDao.obtenerAdministradoresCompletos()
}