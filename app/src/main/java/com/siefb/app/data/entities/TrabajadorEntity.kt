package com.siefb.app.data.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

import java.time.LocalDate
@Entity(
    tableName = "trabajador",
    foreignKeys = [
        ForeignKey(
            entity = PersonaEntity::class,
            parentColumns = ["id"],
            childColumns = ["id"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)
data class TrabajadorEntity(
    @PrimaryKey
    val id: Int,

    val arl: String,

    val diaIngreso: LocalDate
)
