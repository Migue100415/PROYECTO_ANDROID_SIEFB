package com.siefb.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.siefb.app.data.entities.ProfesionalDeportivoEntity
import kotlinx.coroutines.flow.Flow


@Dao
interface ProfesionalDeportivoDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertar(
        profesional: ProfesionalDeportivoEntity
    )

    @Delete
    suspend fun eliminar(
        profesional: ProfesionalDeportivoEntity
    )

    @Query("SELECT * FROM profesional_deportivo")
    fun obtenerTodos(): Flow<List<ProfesionalDeportivoEntity>>

    @Query("SELECT * FROM profesional_deportivo WHERE id = :id")
    suspend fun obtenerPorId(
        id: Int
    ): ProfesionalDeportivoEntity?
}