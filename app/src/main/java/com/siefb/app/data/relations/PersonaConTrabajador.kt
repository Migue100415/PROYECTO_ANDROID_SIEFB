package com.siefb.app.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.siefb.app.data.entities.PersonaEntity
import com.siefb.app.data.entities.TrabajadorEntity

data class PersonaConTrabajador(

    @Embedded
    val persona: PersonaEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val trabajador: TrabajadorEntity?
)