package com.siefb.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.siefb.app.data.entities.JugadorEntity
import com.siefb.app.data.relations.PersonaConJugador
import kotlinx.coroutines.flow.Flow

@Dao
interface JugadorDao {

    @Insert
    suspend fun insertar(jugador: JugadorEntity)

    @Update
    suspend fun actualizar(jugador: JugadorEntity)

    @Delete
    suspend fun eliminar(jugador: JugadorEntity)

    @Transaction
    @Query("""
    SELECT * FROM persona
    WHERE id IN (SELECT id FROM jugador)
""")
    fun obtenerJugadoresCompletos(): Flow<List<PersonaConJugador>>

    @Query("SELECT * FROM jugador WHERE id = :id")
    suspend fun obtenerPorId(id: Int): JugadorEntity?
}