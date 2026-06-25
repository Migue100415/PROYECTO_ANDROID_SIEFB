package com.siefb.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.siefb.app.data.entities.TrabajadorEntity
import com.siefb.app.data.relations.PersonaConTrabajador
import kotlinx.coroutines.flow.Flow

@Dao
interface TrabajadorDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertar(trabajador: TrabajadorEntity)

    @Update
    suspend fun actualizar(trabajador: TrabajadorEntity)

    @Delete
    suspend fun eliminar(trabajador: TrabajadorEntity)

    @Transaction
    @Query("""
    SELECT *
    FROM persona
    WHERE id IN (
        SELECT id
        FROM trabajador
    )
    ORDER BY nombre
""")
    fun obtenerTrabajadoresCompletos(): Flow<List<PersonaConTrabajador>>

    @Query("SELECT * FROM trabajador WHERE id = :id")
    suspend fun obtenerPorId(id: Int): TrabajadorEntity?
}