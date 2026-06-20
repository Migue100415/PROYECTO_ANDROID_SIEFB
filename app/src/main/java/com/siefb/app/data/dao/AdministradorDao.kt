package com.siefb.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.siefb.app.data.entities.AdministradorEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface AdministradorDao {

    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertar(administrador: AdministradorEntity)

    @Delete
    suspend fun eliminar(administrador: AdministradorEntity)

    @Query("SELECT * FROM administrador")
    fun obtenerTodos(): Flow<List<AdministradorEntity>>

    @Query("SELECT * FROM administrador WHERE id = :id")
    suspend fun obtenerPorId(id: Int): AdministradorEntity?
}