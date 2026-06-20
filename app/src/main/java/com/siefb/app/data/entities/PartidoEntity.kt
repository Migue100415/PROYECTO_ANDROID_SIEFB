package com.siefb.app.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate
@Entity(tableName = "partido")
data class PartidoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val fecha: LocalDate,

    val nombreArbitro: String,

    val nombreCancha: String,

    val equipoRival: String
)
