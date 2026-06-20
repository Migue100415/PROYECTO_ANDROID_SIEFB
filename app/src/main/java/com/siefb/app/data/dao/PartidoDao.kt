package com.siefb.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.siefb.app.data.entities.PartidoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PartidoDao {

    @Insert
    suspend fun insertar(partido: PartidoEntity): Long

    @Update
    suspend fun actualizar(partido: PartidoEntity)

    @Delete
    suspend fun eliminar(partido: PartidoEntity)

    @Query("SELECT * FROM partido ORDER BY fecha DESC")
    fun obtenerTodos(): Flow<List<PartidoEntity>>
}