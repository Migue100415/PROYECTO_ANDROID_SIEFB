package com.siefb.app.data.repository

import com.siefb.app.data.dao.JugadorEntrenamientoDao
import com.siefb.app.data.entities.JugadorEntrenamientoEntity

class JugadorEntrenamientoRepository(
    private val dao: JugadorEntrenamientoDao
) {

    suspend fun insertar(
        registro: JugadorEntrenamientoEntity
    ) = dao.insertar(registro)

    suspend fun obtenerPorEntrenamiento(
        entrenamientoId: Int
    ) = dao.obtenerPorEntrenamiento(entrenamientoId)
}