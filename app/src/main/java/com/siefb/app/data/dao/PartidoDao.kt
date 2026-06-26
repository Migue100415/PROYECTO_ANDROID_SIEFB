package com.siefb.app.data.dao


import androidx.room.*

import com.siefb.app.data.entities.PartidoEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface PartidoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(
        partido: PartidoEntity
    ): Long

    @Update
    suspend fun actualizar(
        partido: PartidoEntity
    )

    @Delete
    suspend fun eliminar(
        partido: PartidoEntity
    )

    @Query("""
        SELECT *
        FROM partido
        ORDER BY fecha DESC
    """)
    fun obtenerTodos():
            Flow<List<PartidoEntity>>

    @Query("""
        SELECT *
        FROM partido
        WHERE id = :id
    """)
    suspend fun obtenerPorId(
        id: Int
    ): PartidoEntity?

}