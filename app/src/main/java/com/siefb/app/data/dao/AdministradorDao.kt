package com.siefb.app.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction

import com.siefb.app.data.entities.AdministradorEntity
import com.siefb.app.data.relations.PersonaAdministrador

import kotlinx.coroutines.flow.Flow

@Dao
interface AdministradorDao {

    @Insert(
        onConflict =
            OnConflictStrategy.REPLACE
    )
    suspend fun insertar(
        administrador: AdministradorEntity
    )

    @Delete
    suspend fun eliminar(
        administrador: AdministradorEntity
    )

    @Query(
        """
        SELECT *
        FROM administrador
        WHERE id = :id
        """
    )
    suspend fun obtenerPorId(
        id: Int
    ): AdministradorEntity?

    @Transaction
    @Query(
        """
        SELECT *
        FROM persona
        WHERE id IN (
            SELECT id
            FROM administrador
        )
        ORDER BY nombre
        """
    )
    fun obtenerAdministradoresCompletos():
            Flow<List<PersonaAdministrador>>
}