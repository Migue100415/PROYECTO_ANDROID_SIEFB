package com.siefb.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

import com.siefb.app.data.entities.EntrenamientoEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface EntrenamientoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(
        entrenamiento: EntrenamientoEntity
    )

    @Update
    suspend fun actualizar(
        entrenamiento: EntrenamientoEntity
    )

    @Delete
    suspend fun eliminar(
        entrenamiento: EntrenamientoEntity
    )

    @Query(
        """
        SELECT *
        FROM entrenamiento
        ORDER BY fecha DESC
        """
    )
    fun obtenerTodos(): Flow<List<EntrenamientoEntity>>

    @Query(
        """
        SELECT *
        FROM entrenamiento
        WHERE id = :id
        LIMIT 1
        """
    )
    suspend fun obtenerPorId(
        id: Int
    ): EntrenamientoEntity?

}