package com.siefb.app.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.siefb.app.data.entities.JugadorEntity
import com.siefb.app.data.entities.PersonaEntity

data class PersonaConJugador(
    @Embedded
    val persona: PersonaEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val jugador: JugadorEntity
)
