package com.siefb.app.viewmodel.factory

import android.app.Application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.siefb.app.SiefbApplication

import com.siefb.app.viewmodel.jugador.JugadorViewModel
import com.siefb.app.viewmodel.trabajador.TrabajadorViewModel
import com.siefb.app.viewmodel.administrador.AdministradorViewModel
import com.siefb.app.viewmodel.profesionaldeportivo.ProfesionalDeportivoViewModel
import com.siefb.app.viewmodel.entrenamiento.EntrenamientoViewModel
import com.siefb.app.viewmodel.partido.PartidoViewModel
import com.siefb.app.viewmodel.registrocontable.RegistroContableViewModel
import com.siefb.app.viewmodel.jugadorentrenamiento.JugadorEntrenamientoViewModel

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

            modelClass.isAssignableFrom(
                AdministradorViewModel::class.java
            ) -> {

                AdministradorViewModel(
                    container.administradorRepository
                ) as T
            }

            modelClass.isAssignableFrom(
                ProfesionalDeportivoViewModel::class.java
            ) -> {

                ProfesionalDeportivoViewModel(
                    container.profesionalDeportivoRepository
                ) as T
            }

            modelClass.isAssignableFrom(

                EntrenamientoViewModel::class.java

            ) -> {

                EntrenamientoViewModel(

                    container.entrenamientoRepository

                ) as T

            }

            modelClass.isAssignableFrom(
                PartidoViewModel::class.java
            ) -> {

                PartidoViewModel(
                    container.partidoRepository
                ) as T

            }

            modelClass.isAssignableFrom(
                RegistroContableViewModel::class.java
            ) -> {

                RegistroContableViewModel(
                    container.registroContableRepository
                ) as T

            }

            modelClass.isAssignableFrom(
                JugadorEntrenamientoViewModel::class.java
            ) -> {

                JugadorEntrenamientoViewModel(
                    container.jugadorEntrenamientoRepository
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