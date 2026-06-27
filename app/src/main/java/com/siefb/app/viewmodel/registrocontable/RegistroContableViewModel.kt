package com.siefb.app.viewmodel.registrocontable

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.siefb.app.data.entities.RegistroContableEntity
import com.siefb.app.data.enums.TipoMovimiento
import com.siefb.app.data.repository.RegistroContableRepository

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

import kotlinx.coroutines.launch

class RegistroContableViewModel(

    private val repository:
    RegistroContableRepository

) : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            RegistroContableUiState(
                isLoading = true
            )
        )

    val uiState:
            StateFlow<
                    RegistroContableUiState
                    > =
        _uiState.asStateFlow()

    init {

        cargarRegistros()

    }

    private fun cargarRegistros() {

        viewModelScope.launch {

            repository.obtenerTodos()

                .collect { lista ->

                    _uiState.value =
                        _uiState.value.copy(

                            registros = lista,

                            isLoading = false

                        )

                }

        }

    }

    fun registrarRegistro(

        fecha: String,

        cantidadPago: Int,

        comprobante: String,

        tipo: TipoMovimiento,

        administradorId: Int

    ) {

        viewModelScope.launch {

            repository.insertar(

                RegistroContableEntity(

                    fecha = fecha,

                    cantidadPago = cantidadPago,

                    comprobante = comprobante,

                    tipo = tipo,

                    administradorId = administradorId

                )

            )

        }

    }

    fun actualizarRegistro(

        id: Int,

        fecha: String,

        cantidadPago: Int,

        comprobante: String,

        tipo: TipoMovimiento,

        administradorId: Int

    ) {

        viewModelScope.launch {

            repository.actualizar(

                RegistroContableEntity(

                    id = id,

                    fecha = fecha,

                    cantidadPago = cantidadPago,

                    comprobante = comprobante,

                    tipo = tipo,

                    administradorId = administradorId

                )

            )

        }

    }

    fun eliminarRegistro(

        registro: RegistroContableEntity

    ) {

        viewModelScope.launch {

            repository.eliminar(
                registro
            )

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

                    registroSeleccionado =
                        registro

                )

        }

    }

}