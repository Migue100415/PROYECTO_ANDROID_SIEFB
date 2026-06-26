package com.siefb.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

import com.siefb.app.data.entities.ProfesionalDeportivoEntity
import com.siefb.app.data.relations.PersonaProfesionalDeportivo

import kotlinx.coroutines.flow.Flow

@Dao
interface ProfesionalDeportivoDao {

    @Insert(
        onConflict =
            OnConflictStrategy.REPLACE
    )
    suspend fun insertar(
        profesionalDeportivo:
        ProfesionalDeportivoEntity
    )

    @Delete
    suspend fun eliminar(
        profesionalDeportivo:
        ProfesionalDeportivoEntity
    )

    @Query(
        """
        SELECT *
        FROM profesional_deportivo
        WHERE id = :id
        """
    )
    suspend fun obtenerPorId(
        id: Int
    ): ProfesionalDeportivoEntity?

    @Transaction
    @Query(
        """
        SELECT *
        FROM persona
        WHERE id IN (
            SELECT id
            FROM profesional_deportivo
        )
        ORDER BY nombre
        """
    )
    fun obtenerProfesionalesCompletos():
            Flow<List<PersonaProfesionalDeportivo>>
}