package com.siefb.app.viewmodel.partido

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.siefb.app.data.entities.PartidoEntity
import com.siefb.app.data.repository.PartidoRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

import kotlinx.coroutines.launch

class PartidoViewModel(

    private val repository: PartidoRepository

) : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            PartidoUiState(
                isLoading = true
            )
        )

    val uiState:
            StateFlow<PartidoUiState> =
        _uiState.asStateFlow()

    init {
        cargarPartidos()
    }

    private fun cargarPartidos() {

        viewModelScope.launch {

            repository.obtenerTodos()
                .collect { lista ->

                    _uiState.value =
                        _uiState.value.copy(

                            partidos = lista,

                            isLoading = false

                        )

                }

        }

    }

    fun registrarPartido(

        fecha: String,

        nombreArbitro: String,

        nombreCancha: String,

        equipoRival: String

    ) {

        viewModelScope.launch {

            repository.insertar(

                PartidoEntity(

                    fecha = fecha,

                    nombreArbitro = nombreArbitro,

                    nombreCancha = nombreCancha,

                    equipoRival = equipoRival

                )

            )

        }

    }

    fun actualizarPartido(

        id: Int,

        fecha: String,

        nombreArbitro: String,

        nombreCancha: String,

        equipoRival: String

    ) {

        viewModelScope.launch {

            repository.actualizar(

                PartidoEntity(

                    id = id,

                    fecha = fecha,

                    nombreArbitro = nombreArbitro,

                    nombreCancha = nombreCancha,

                    equipoRival = equipoRival

                )

            )

        }

    }

    fun eliminarPartido(
        partido: PartidoEntity
    ) {

        viewModelScope.launch {

            repository.eliminar(partido)

        }

    }

    fun cargarPartido(
        id: Int
    ) {

        viewModelScope.launch {

            val partido =
                repository.obtenerPorId(id)

            _uiState.value =
                _uiState.value.copy(

                    partidoSeleccionado = partido

                )

        }

    }

}
