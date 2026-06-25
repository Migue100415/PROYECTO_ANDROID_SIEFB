package com.siefb.app.data.relations

import androidx.room.Embedded
import androidx.room.Relation

import com.siefb.app.data.entities.PersonaEntity
import com.siefb.app.data.entities.TrabajadorEntity
import com.siefb.app.data.entities.AdministradorEntity

data class PersonaAdministrador(

    @Embedded
    val persona: PersonaEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val trabajador: TrabajadorEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val administrador: AdministradorEntity
)