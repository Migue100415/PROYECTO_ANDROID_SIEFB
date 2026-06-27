package com.siefb.app.data.dao

import androidx.room.*

import com.siefb.app.data.entities.RegistroContableEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface RegistroContableDao {

    @Insert(
        onConflict = OnConflictStrategy.REPLACE
    )
    suspend fun insertar(
        registro: RegistroContableEntity
    ): Long

    @Update
    suspend fun actualizar(
        registro: RegistroContableEntity
    )

    @Delete
    suspend fun eliminar(
        registro: RegistroContableEntity
    )

    @Query(
        """
        SELECT *
        FROM registro_contable
        ORDER BY fecha DESC
        """
    )
    fun obtenerTodos():
            Flow<List<RegistroContableEntity>>

    @Query(
        """
        SELECT *
        FROM registro_contable
        WHERE id = :id
        """
    )
    suspend fun obtenerPorId(
        id: Int
    ): RegistroContableEntity?

}