package com.siefb.app.viewmodel.administrador

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.siefb.app.data.entities.AdministradorEntity
import com.siefb.app.data.repository.AdministradorRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

import kotlinx.coroutines.launch

class AdministradorViewModel(

    private val administradorRepository:
    AdministradorRepository

) : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            AdministradorUiState(
                isLoading = true
            )
        )

    val uiState:
            StateFlow<AdministradorUiState> =
        _uiState.asStateFlow()

    init {
        cargarAdministradores()
    }

    private fun cargarAdministradores() {

        viewModelScope.launch {

            administradorRepository
                .obtenerAdministradoresCompletos()
                .collect { administradores ->

                    _uiState.value =
                        _uiState.value.copy(
                            administradores =
                                administradores,

                            isLoading = false
                        )
                }
        }
    }

    fun registrarAdministrador(
        trabajadorId: Int
    ) {

        viewModelScope.launch {

            try {

                administradorRepository
                    .insertar(

                        AdministradorEntity(
                            id = trabajadorId
                        )

                    )

            } catch (e: Exception) {

                _uiState.value =
                    _uiState.value.copy(
                        error = e.message
                    )
            }
        }
    }

    fun eliminarAdministrador(
        administradorId: Int
    ) {

        viewModelScope.launch {

            try {

                administradorRepository
                    .eliminar(

                        AdministradorEntity(
                            id = administradorId
                        )

                    )

            } catch (e: Exception) {

                _uiState.value =
                    _uiState.value.copy(
                        error = e.message
                    )
            }
        }
    }
}