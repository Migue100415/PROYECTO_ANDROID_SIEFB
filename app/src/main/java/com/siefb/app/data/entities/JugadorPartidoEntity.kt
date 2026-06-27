package com.siefb.app.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(

    tableName = "jugador_partido",

    foreignKeys = [

        ForeignKey(

            entity = JugadorEntity::class,

            parentColumns = ["id"],

            childColumns = ["jugadorId"],

            onDelete = ForeignKey.CASCADE

        ),

        ForeignKey(

            entity = PartidoEntity::class,

            parentColumns = ["id"],

            childColumns = ["partidoId"],

            onDelete = ForeignKey.CASCADE

        )

    ],

    indices = [

        Index("jugadorId"),

        Index("partidoId")

    ]

)

data class JugadorPartidoEntity(

    @PrimaryKey(autoGenerate = true)

    val id: Int = 0,

    val jugadorId: Int,

    val partidoId: Int,

    val goles: Int,

    val asistencias: Int,

    val amarillas: Int,

    val rojas: Int,

    val asistencia: Boolean

)