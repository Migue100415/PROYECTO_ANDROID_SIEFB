package com.siefb.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.siefb.app.data.entities.JugadorEntrenamientoEntity


@Dao
interface JugadorEntrenamientoDao {

    @Insert
    suspend fun insertar(registro: JugadorEntrenamientoEntity)

    @Query("""
        SELECT * FROM jugador_entrenamiento
        WHERE entrenamientoId = :entrenamientoId
    """)
    suspend fun obtenerPorEntrenamiento(
        entrenamientoId: Int
    ): List<JugadorEntrenamientoEntity>
}