package com.siefb.app.data.dao

import androidx.room.*

import com.siefb.app.data.entities.JugadorPartidoEntity

import kotlinx.coroutines.flow.Flow

@Dao
interface JugadorPartidoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertar(
        registro: JugadorPartidoEntity
    ): Long

    @Update
    suspend fun actualizar(
        registro: JugadorPartidoEntity
    )

    @Delete
    suspend fun eliminar(
        registro: JugadorPartidoEntity
    )

    @Query("""
        SELECT *
        FROM jugador_partido
        ORDER BY id DESC
    """)
    fun obtenerTodos():
            Flow<List<JugadorPartidoEntity>>

    @Query("""
        SELECT *
        FROM jugador_partido
        WHERE id = :id
    """)
    suspend fun obtenerPorId(
        id: Int
    ): JugadorPartidoEntity?

}