package com.siefb.app.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey
import com.siefb.app.data.enums.TipoMovimiento

@Entity(

    tableName = "registro_contable",

    foreignKeys = [

        ForeignKey(

            entity = AdministradorEntity::class,

            parentColumns = ["id"],

            childColumns = ["administradorId"],

            onDelete = ForeignKey.CASCADE

        )

    ],

    indices = [

        Index("administradorId")

    ]

)

data class RegistroContableEntity(

    @PrimaryKey(autoGenerate = true)

    val id: Int = 0,

    val fecha: String,

    val cantidadPago: Int,

    val comprobante: String,

    val tipo: TipoMovimiento,

    val administradorId: Int

)