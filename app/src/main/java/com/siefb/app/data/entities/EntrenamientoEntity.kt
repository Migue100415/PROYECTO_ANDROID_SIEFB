package com.siefb.app.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
@Entity(tableName = "entrenamiento")
data class EntrenamientoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val fecha: LocalDate,

    val observaciones: String?
)
