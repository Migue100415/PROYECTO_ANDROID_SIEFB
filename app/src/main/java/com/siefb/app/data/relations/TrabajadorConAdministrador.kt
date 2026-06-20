package com.siefb.app.data.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.siefb.app.data.entities.AdministradorEntity
import com.siefb.app.data.entities.TrabajadorEntity

data class TrabajadorConAdministrador(

    @Embedded
    val trabajador: TrabajadorEntity,

    @Relation(
        parentColumn = "id",
        entityColumn = "id"
    )
    val administrador: AdministradorEntity?
)