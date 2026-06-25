package com.siefb.app.viewmodel.trabajador

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siefb.app.data.entities.JugadorEntity
import com.siefb.app.data.entities.TrabajadorEntity
import com.siefb.app.data.entities.PersonaEntity
import com.siefb.app.data.repository.PersonaRepository
import com.siefb.app.data.repository.TrabajadorRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import com.siefb.app.data.relations.PersonaConTrabajador

class TrabajadorViewModel(

    private val personaRepository:
    PersonaRepository,
    private val trabajadorRepository:
    TrabajadorRepository

) : ViewModel() {

    private val _uiState =
        MutableStateFlow(
            TrabajadorUiState(
                isLoading = true
            )
        )

    val uiState =
        _uiState.asStateFlow()

    init {
        cargarTrabajadores()
    }

    private fun cargarTrabajadores() {

        viewModelScope.launch {

            trabajadorRepository
                .obtenerTrabajadoresCompletos()
                .collect { trabajadores ->

                    _uiState.value =
                        _uiState.value.copy(
                            trabajadores = trabajadores,
                            isLoading = false
                        )
                }
        }
    }

    fun registrarTrabajador(

        documento: String,
        nombre: String,
        direccion: String,
        telefono: String,

        actaMedica: String,
        eps: String,
        foto: String,

        fechaNacimiento: LocalDate,

        arl: String,
        diaIngreso: LocalDate
    ){

        viewModelScope.launch {

            try {

                val personaId = personaRepository.insertar(
                    PersonaEntity(
                        documento = documento,
                        nombre = nombre,
                        direccion = direccion,
                        telefono = telefono,
                        actaMedica = actaMedica,
                        eps = eps,
                        foto = foto,
                        fechaNacimiento = fechaNacimiento
                    )
                ).toInt()

                trabajadorRepository.insertar(
                    TrabajadorEntity(
                        id = personaId,
                        arl = arl,
                        diaIngreso = diaIngreso
                    )
                )

            } catch (e: Exception) {

                _uiState.value = _uiState.value.copy(
                    error = e.message
                )
            }
        }
    }
    fun cargarTrabajador(id: Int) {

        if (id == -1) return

        viewModelScope.launch {

            try {

                val persona =
                    personaRepository.obtenerPorId(id)

                val trabajador =


                    trabajadorRepository.obtenerPorId(id)

                if (persona != null && trabajador != null) {

                    _uiState.value = _uiState.value.copy(
                        trabajadorSeleccionado = PersonaConTrabajador(
                            persona = persona,
                            trabajador = trabajador
                        )
                    )
                }

            } catch (e: Exception) {

                _uiState.value = _uiState.value.copy(
                    error = e.message
                )
            }
        }
    }
    fun actualizarTrabajador(
        id: Int,
        documento: String,
        nombre: String,
        direccion: String,
        telefono: String,
        actaMedica: String,
        eps: String,
        foto: String,
        fechaNacimiento: LocalDate,
        arl: String,
        diaIngreso: LocalDate
    ) {

        viewModelScope.launch {

            try {

                personaRepository.actualizar(
                    PersonaEntity(
                        id = id,
                        documento = documento,
                        nombre = nombre,
                        direccion = direccion,
                        telefono = telefono,
                        actaMedica = actaMedica,
                        eps = eps,
                        foto = foto,
                        fechaNacimiento = fechaNacimiento
                    )
                )

                trabajadorRepository.actualizar(
                    TrabajadorEntity(
                        id = id,
                        arl = arl,
                        diaIngreso = diaIngreso
                    )
                )

            } catch (e: Exception) {

                _uiState.value = _uiState.value.copy(
                    error = e.message
                )
            }
        }
    }

    fun eliminarTrabajador(persona: PersonaEntity) {

        viewModelScope.launch {

            try {

                personaRepository.eliminar(persona)

            } catch (e: Exception) {

                _uiState.value = _uiState.value.copy(
                    error = e.message
                )
            }
        }
    }


}