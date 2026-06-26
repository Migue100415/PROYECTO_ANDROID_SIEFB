package com.siefb.app.viewmodel.entrenamiento

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.siefb.app.data.entities.EntrenamientoEntity
import com.siefb.app.data.repository.EntrenamientoRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

import kotlinx.coroutines.launch

class EntrenamientoViewModel(

    private val entrenamientoRepository: EntrenamientoRepository

) : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            EntrenamientoUiState(
                isLoading = true
            )
        )

    val uiState: StateFlow<EntrenamientoUiState> =
        _uiState.asStateFlow()

    init {
        cargarEntrenamientos()
    }

    private fun cargarEntrenamientos() {

        viewModelScope.launch {

            entrenamientoRepository
                .obtenerTodos()
                .collect { lista ->

                    _uiState.value =
                        _uiState.value.copy(
                            entrenamientos = lista,
                            isLoading = false
                        )

                }

        }

    }

    fun registrarEntrenamiento(

        fecha: String,

        observaciones: String

    ) {

        viewModelScope.launch {

            try {

                entrenamientoRepository.insertar(

                    EntrenamientoEntity(

                        fecha = fecha,

                        observaciones = observaciones

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

    fun actualizarEntrenamiento(

        id: Int,

        fecha: String,

        observaciones: String

    ) {

        viewModelScope.launch {

            try {

                entrenamientoRepository.actualizar(

                    EntrenamientoEntity(

                        id = id,

                        fecha = fecha,

                        observaciones = observaciones

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

    fun eliminarEntrenamiento(

        entrenamiento: EntrenamientoEntity

    ) {

        viewModelScope.launch {

            entrenamientoRepository.eliminar(
                entrenamiento
            )

        }

    }

    fun cargarEntrenamiento(

        id: Int

    ) {

        viewModelScope.launch {

            val entrenamiento =
                entrenamientoRepository
                    .obtenerPorId(id)

            _uiState.value =
                _uiState.value.copy(
                    entrenamientoSeleccionado =
                        entrenamiento
                )

        }

    }

}