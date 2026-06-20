package com.siefb.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.siefb.app.data.entities.PersonaEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PersonaDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertar(persona: PersonaEntity): Long

    @Update
    suspend fun actualizar(persona: PersonaEntity)

    @Delete
    suspend fun eliminar(persona: PersonaEntity)

    @Query("SELECT * FROM persona ORDER BY nombre")
    fun obtenerTodas(): Flow<List<PersonaEntity>>

    @Query("SELECT * FROM persona WHERE id = :id")
    suspend fun obtenerPorId(id: Int): PersonaEntity?

    @Query("SELECT * FROM persona WHERE documento = :documento LIMIT 1")
    suspend fun obtenerPorDocumento(documento: String): PersonaEntity?
}