package com.siefb.app.data.converters

import androidx.room.TypeConverter
import com.siefb.app.data.entities.TipoMovimiento
import java.time.LocalDate

class Converters {

    @TypeConverter
    fun fromLocalDate(date: LocalDate?): String? =
        date?.toString()

    @TypeConverter
    fun toLocalDate(date: String?): LocalDate? =
        date?.let { LocalDate.parse(it) }

    @TypeConverter
    fun fromTipoMovimiento(tipo: TipoMovimiento): String =
        tipo.name

    @TypeConverter
    fun toTipoMovimiento(valor: String): TipoMovimiento =
        TipoMovimiento.valueOf(valor)
}