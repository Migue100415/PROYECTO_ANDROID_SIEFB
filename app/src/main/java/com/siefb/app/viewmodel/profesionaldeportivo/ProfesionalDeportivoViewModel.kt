package com.siefb.app.viewmodel.profesionaldeportivo

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.siefb.app.data.entities
.ProfesionalDeportivoEntity

import com.siefb.app.data.repository
.ProfesionalDeportivoRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

import kotlinx.coroutines.launch

class ProfesionalDeportivoViewModel(

    private val profesionalDeportivoRepository:
    ProfesionalDeportivoRepository

) : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            ProfesionalDeportivoUiState(
                isLoading = true
            )
        )

    val uiState:
            StateFlow<
                    ProfesionalDeportivoUiState
                    > =
        _uiState.asStateFlow()

    init {
        cargarProfesionales()
    }

    private fun cargarProfesionales() {

        viewModelScope.launch {

            profesionalDeportivoRepository
                .obtenerProfesionalesCompletos()
                .collect { profesionales ->

                    _uiState.value =
                        _uiState.value.copy(
                            profesionales =
                                profesionales,

                            isLoading = false
                        )
                }
        }
    }

    fun registrarProfesional(
        trabajadorId: Int
    ) {

        viewModelScope.launch {

            try {

                profesionalDeportivoRepository
                    .insertar(

                        ProfesionalDeportivoEntity(
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

    fun eliminarProfesional(
        profesionalId: Int
    ) {

        viewModelScope.launch {

            try {

                profesionalDeportivoRepository
                    .eliminar(

                        ProfesionalDeportivoEntity(
                            id = profesionalId
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