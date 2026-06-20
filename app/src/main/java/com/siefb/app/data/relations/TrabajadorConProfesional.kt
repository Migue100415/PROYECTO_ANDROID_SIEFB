package com.siefb.app.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.siefb.app.data.entities.ProfesionalDeportivoEntity
import com.siefb.app.data.entities.TrabajadorEntity

data class TrabajadorConProfesional(

    @Embedded
    val trabajador: TrabajadorEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val profesional: ProfesionalDeportivoEntity?
)