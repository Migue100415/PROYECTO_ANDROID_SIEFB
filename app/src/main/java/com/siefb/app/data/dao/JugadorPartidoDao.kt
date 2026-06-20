package com.siefb.app.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.siefb.app.data.entities.JugadorPartidoEntity

@Dao
interface JugadorPartidoDao {

    @Insert
    suspend fun insertar(registro: JugadorPartidoEntity)

    @Query("""
        SELECT * FROM jugador_partido
        WHERE partidoId = :partidoId
    """)
    suspend fun obtenerPorPartido(
        partidoId: Int
    ): List<JugadorPartidoEntity>
}