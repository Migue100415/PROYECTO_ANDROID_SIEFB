package com.siefb.app.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "jugador_entrenamiento",
    foreignKeys = [
        ForeignKey(
            entity = JugadorEntity::class,
            parentColumns = ["id"],
            childColumns = ["jugadorId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = EntrenamientoEntity::class,
            parentColumns = ["id"],
            childColumns = ["entrenamientoId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class JugadorEntrenamientoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val jugadorId: Int,

    val entrenamientoId: Int,

    val asistencia: Boolean
)
