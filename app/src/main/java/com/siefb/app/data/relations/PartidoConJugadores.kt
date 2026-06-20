package com.siefb.app.data.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.siefb.app.data.entities.JugadorEntity
import com.siefb.app.data.entities.JugadorPartidoEntity
import com.siefb.app.data.entities.PartidoEntity

data class PartidoConJugadores(

    @Embedded
    val partido: PartidoEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id",
        associateBy = Junction(
            value = JugadorPartidoEntity::class,
            parentColumn = "partidoId",
            entityColumn = "jugadorId"
        )
    )
    val jugadores: List<JugadorEntity>
)