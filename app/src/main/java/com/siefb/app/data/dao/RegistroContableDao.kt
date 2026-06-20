package com.siefb.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.siefb.app.data.entities.RegistroContableEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface RegistroContableDao {

    @Insert
    suspend fun insertar(registro: RegistroContableEntity)

    @Update
    suspend fun actualizar(registro: RegistroContableEntity)

    @Delete
    suspend fun eliminar(registro: RegistroContableEntity)

    @Query("SELECT * FROM registro_contable ORDER BY fecha DESC")
    fun obtenerTodos(): Flow<List<RegistroContableEntity>>
}