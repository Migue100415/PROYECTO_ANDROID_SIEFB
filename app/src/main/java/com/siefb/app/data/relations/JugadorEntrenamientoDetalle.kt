package com.siefb.app.data.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.siefb.app.data.entities.EntrenamientoEntity
import com.siefb.app.data.entities.JugadorEntity
import com.siefb.app.data.entities.JugadorEntrenamientoEntity

data class JugadorEntrenamientoDetalle(
    @Embedded
    val entrenamiento: EntrenamientoEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = JugadorEntrenamientoEntity::class,
            parentColumn = "entrenamientoId",
            entityColumn = "jugadorId"
        )
    )
    val jugadores: List<JugadorEntity>
)
