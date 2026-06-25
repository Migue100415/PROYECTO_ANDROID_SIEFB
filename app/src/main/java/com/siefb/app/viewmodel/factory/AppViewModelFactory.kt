package com.siefb.app.viewmodel.factory

import android.app.Application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.siefb.app.SiefbApplication

import com.siefb.app.viewmodel.jugador.JugadorViewModel
import com.siefb.app.viewmodel.trabajador.TrabajadorViewModel

class AppViewModelFactory(
    private val application: Application
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {

        val container =
            (application as SiefbApplication)
                .container

        return when {

            modelClass.isAssignableFrom(
                JugadorViewModel::class.java
            ) -> {

                JugadorViewModel(
                    container.personaRepository,
                    container.jugadorRepository
                ) as T
            }

            modelClass.isAssignableFrom(
                TrabajadorViewModel::class.java
            ) -> {

                TrabajadorViewModel(
                    container.personaRepository,
                    container.trabajadorRepository
                ) as T
            }

            else -> {

                throw IllegalArgumentException(
                    "ViewModel no encontrado"
                )
            }
        }
    }
}