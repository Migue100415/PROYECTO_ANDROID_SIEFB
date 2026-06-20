package com.siefb.app.data.database

import android.content.Context
import androidx.room.Room

object DatabaseProvider {

    @Volatile
    private var INSTANCE: SiefbDatabase? = null

    fun getDatabase(context: Context): SiefbDatabase {

        return INSTANCE ?: synchronized(this) {

            val instance = Room.databaseBuilder(
                context.applicationContext,
                SiefbDatabase::class.java,
                "siefb.db"
            ).build()

            INSTANCE = instance

            instance
        }
    }
}