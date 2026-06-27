package com.siefb.app.viewmodel.jugadorpartido

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.siefb.app.data.entities.JugadorPartidoEntity
import com.siefb.app.data.repository.JugadorPartidoRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class JugadorPartidoViewModel(

    private val repository: JugadorPartidoRepository

) : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            JugadorPartidoUiState(
                isLoading = true
            )
        )

    val uiState: StateFlow<JugadorPartidoUiState> =
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

        partidoId: Int,

        goles: Int,

        asistencias: Int,

        amarillas: Int,

        rojas: Int,

        asistencia: Boolean

    ) {

        viewModelScope.launch {

            repository.insertar(

                JugadorPartidoEntity(

                    jugadorId = jugadorId,

                    partidoId = partidoId,

                    goles = goles,

                    asistencias = asistencias,

                    amarillas = amarillas,

                    rojas = rojas,

                    asistencia = asistencia

                )

            )

        }

    }

    fun actualizarRegistro(

        id: Int,

        jugadorId: Int,

        partidoId: Int,

        goles: Int,

        asistencias: Int,

        amarillas: Int,

        rojas: Int,

        asistencia: Boolean

    ) {

        viewModelScope.launch {

            repository.actualizar(

                JugadorPartidoEntity(

                    id = id,

                    jugadorId = jugadorId,

                    partidoId = partidoId,

                    goles = goles,

                    asistencias = asistencias,

                    amarillas = amarillas,

                    rojas = rojas,

                    asistencia = asistencia

                )

            )

        }

    }

    fun eliminarRegistro(
        registro: JugadorPartidoEntity
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