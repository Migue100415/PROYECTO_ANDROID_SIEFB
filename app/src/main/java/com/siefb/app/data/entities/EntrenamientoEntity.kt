package com.siefb.app.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "entrenamiento")
data class EntrenamientoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val fecha: String,

    val observaciones: String?
)
