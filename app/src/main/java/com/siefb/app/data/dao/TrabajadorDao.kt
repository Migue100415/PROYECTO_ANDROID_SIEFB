package com.siefb.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.siefb.app.data.entities.TrabajadorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrabajadorDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertar(trabajador: TrabajadorEntity)

    @Update
    suspend fun actualizar(trabajador: TrabajadorEntity)

    @Delete
    suspend fun eliminar(trabajador: TrabajadorEntity)

    @Query("SELECT * FROM trabajador ORDER BY diaIngreso DESC")
    fun obtenerTodos(): Flow<List<TrabajadorEntity>>

    @Query("SELECT * FROM trabajador WHERE id = :id")
    suspend fun obtenerPorId(id: Int): TrabajadorEntity?
}