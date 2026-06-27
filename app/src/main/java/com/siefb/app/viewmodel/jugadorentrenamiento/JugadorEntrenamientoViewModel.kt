package com.siefb.app.viewmodel.jugadorentrenamiento

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.siefb.app.data.entities.JugadorEntrenamientoEntity
import com.siefb.app.data.repository.JugadorEntrenamientoRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JugadorEntrenamientoViewModel(

    private val repository: JugadorEntrenamientoRepository

) : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            JugadorEntrenamientoUiState(
                isLoading = true
            )
        )

    val uiState: StateFlow<JugadorEntrenamientoUiState> =
        _uiState.asStateFlow()

    init {
        cargarRegistros()
    }

    private fun cargarRegistros() {

        viewModelScope.launch {

            repository.obtenerTodos().collect { lista ->

                _uiState.value =
                    _uiState.value.copy(
                        registros = lista,
                        isLoading = false
                    )

            }

        }

    }

    fun registrarRegistro(

        jugadorId: Int,

        entrenamientoId: Int,

        asistencia: Boolean

    ) {

        viewModelScope.launch {

            repository.insertar(

                JugadorEntrenamientoEntity(

                    jugadorId = jugadorId,

                    entrenamientoId = entrenamientoId,

                    asistencia = asistencia

                )

            )

        }

    }

    fun actualizarRegistro(

        id: Int,

        jugadorId: Int,

        entrenamientoId: Int,

        asistencia: Boolean

    ) {

        viewModelScope.launch {

            repository.actualizar(

                JugadorEntrenamientoEntity(

                    id = id,

                    jugadorId = jugadorId,

                    entrenamientoId = entrenamientoId,

                    asistencia = asistencia

                )

            )

        }

    }

    fun eliminarRegistro(
        registro: JugadorEntrenamientoEntity
    ) {

        viewModelScope.launch {

            repository.eliminar(registro)

        }

    }

    fun cargarRegistro(
        id: Int
    ) {

        viewModelScope.launch {

            val registro =
                repository.obtenerPorId(id)

            _uiState.value =
                _uiState.value.copy(
                    registroSeleccionado = registro
                )

        }

    }

}