package com.siefb.app.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.siefb.app.data.converters.Converters
import com.siefb.app.data.dao.AdministradorDao
import com.siefb.app.data.dao.EntrenamientoDao
import com.siefb.app.data.dao.JugadorDao
import com.siefb.app.data.dao.JugadorEntrenamientoDao
import com.siefb.app.data.dao.JugadorPartidoDao
import com.siefb.app.data.dao.PartidoDao
import com.siefb.app.data.dao.PersonaDao
import com.siefb.app.data.dao.ProfesionalDeportivoDao
import com.siefb.app.data.dao.RegistroContableDao
import com.siefb.app.data.dao.TrabajadorDao
import com.siefb.app.data.entities.AdministradorEntity
import com.siefb.app.data.entities.EntrenamientoEntity
import com.siefb.app.data.entities.JugadorEntity
import com.siefb.app.data.entities.JugadorEntrenamientoEntity
import com.siefb.app.data.entities.JugadorPartidoEntity
import com.siefb.app.data.entities.PartidoEntity
import com.siefb.app.data.entities.PersonaEntity
import com.siefb.app.data.entities.ProfesionalDeportivoEntity
import com.siefb.app.data.entities.RegistroContableEntity
import com.siefb.app.data.entities.TrabajadorEntity

@Database(
    entities = [
        PersonaEntity::class,
        TrabajadorEntity::class,
        ProfesionalDeportivoEntity::class,
        AdministradorEntity::class,
        JugadorEntity::class,
        EntrenamientoEntity::class,
        PartidoEntity::class,
        RegistroContableEntity::class,
        JugadorEntrenamientoEntity::class,
        JugadorPartidoEntity::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class SiefbDatabase : RoomDatabase() {

    abstract fun personaDao(): PersonaDao

    abstract fun jugadorDao(): JugadorDao

    abstract fun entrenamientoDao(): EntrenamientoDao

    abstract fun partidoDao(): PartidoDao

    abstract fun registroContableDao(): RegistroContableDao

    abstract fun jugadorEntrenamientoDao(): JugadorEntrenamientoDao

    abstract fun jugadorPartidoDao(): JugadorPartidoDao

    abstract fun trabajadorDao(): TrabajadorDao

    abstract fun administradorDao(): AdministradorDao

    abstract fun profesionalDeportivoDao(): ProfesionalDeportivoDao
}