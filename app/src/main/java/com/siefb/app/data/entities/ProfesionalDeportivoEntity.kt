package com.siefb.app.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "profesional_deportivo",
    foreignKeys = [
        ForeignKey(
            entity = TrabajadorEntity::class,
            parentColumns = ["id"],
            childColumns = ["id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class ProfesionalDeportivoEntity(
    @PrimaryKey
    val id: Int
)
