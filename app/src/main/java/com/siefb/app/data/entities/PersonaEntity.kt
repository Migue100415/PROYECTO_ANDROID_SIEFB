package com.siefb.app.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Index
import java.time.LocalDate

@Entity(
    tableName = "persona",
    indices = [
        Index(value = ["documento"], unique = true)
    ]
)
data class PersonaEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val documento: String,
    val nombre: String,
    val direccion: String,
    val telefono: String,
    val actaMedica: String,
    val eps: String,
    val foto: String,
    val fechaNacimiento: LocalDate
)