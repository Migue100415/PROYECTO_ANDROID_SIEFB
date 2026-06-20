package com.siefb.app.data.repository

import com.siefb.app.data.dao.PersonaDao
import com.siefb.app.data.entities.PersonaEntity

class PersonaRepository(
    private val personaDao: PersonaDao
) {

    fun obtenerTodas() = personaDao.obtenerTodas()

    suspend fun obtenerPorId(id: Int) =
        personaDao.obtenerPorId(id)

    suspend fun obtenerPorDocumento(documento: String) =
        personaDao.obtenerPorDocumento(documento)

    suspend fun insertar(persona: PersonaEntity): Long =
        personaDao.insertar(persona)

    suspend fun actualizar(persona: PersonaEntity) =
        personaDao.actualizar(persona)

    suspend fun eliminar(persona: PersonaEntity) =
        personaDao.eliminar(persona)
}