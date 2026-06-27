package com.siefb.app.data.dao

import androidx.room.*

import com.siefb.app.data.entities.JugadorEntrenamientoEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface JugadorEntrenamientoDao {

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertar(
        registro: JugadorEntrenamientoEntity
    ): Long

    @Update
    suspend fun actualizar(
        registro: JugadorEntrenamientoEntity
    )

    @Delete
    suspend fun eliminar(
        registro: JugadorEntrenamientoEntity
    )

    @Query(
        """
        SELECT *
        FROM jugador_entrenamiento
        ORDER BY id DESC
        """
    )
    fun obtenerTodos():
            Flow<List<JugadorEntrenamientoEntity>>

    @Query(
        """
        SELECT *
        FROM jugador_entrenamiento
        WHERE id = :id
        """
    )
    suspend fun obtenerPorId(
        id: Int
    ): JugadorEntrenamientoEntity?

}