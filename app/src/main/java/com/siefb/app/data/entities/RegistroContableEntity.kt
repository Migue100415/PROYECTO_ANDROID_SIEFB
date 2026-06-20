package com.siefb.app.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import java.time.LocalDate
@Entity(
    tableName = "registro_contable",
    foreignKeys = [
        ForeignKey(
            entity = AdministradorEntity::class,
            parentColumns = ["id"],
            childColumns = ["administradorId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class RegistroContableEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val fecha: LocalDate,

    val cantidadPago: Int,

    val comprobante: String,

    val tipo: TipoMovimiento,

    val administradorId: Int
)
