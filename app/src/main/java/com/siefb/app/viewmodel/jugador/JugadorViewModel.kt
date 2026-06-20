package com.siefb.app.viewmodel.jugador


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.siefb.app.data.entities.JugadorEntity
import com.siefb.app.data.entities.PersonaEntity
import com.siefb.app.data.repository.JugadorRepository
import com.siefb.app.data.repository.PersonaRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate

class JugadorViewModel(
    private val personaRepository: PersonaRepository,
    private val jugadorRepository: JugadorRepository
) : ViewModel() {

    private val _uiState =
        MutableStateFlow(JugadorUiState(isLoading = true))

    val uiState: StateFlow<JugadorUiState> =
        _uiState.asStateFlow()

    init {
        cargarJugadores()
    }

    private fun cargarJugadores() {

        viewModelScope.launch {

            jugadorRepository.obtenerTodos()
                .collect { jugadores ->

                    _uiState.value = _uiState.value.copy(
                        jugadores = jugadores,
                        isLoading = false
                    )
                }
        }
    }

    fun registrarJugador(
        documento: String,
        nombre: String,
        direccion: String,
        telefono: String,
        actaMedica: String,
        eps: String,
        foto: String,
        fechaNacimiento: LocalDate,
        nombreAcudiente: String,
        diaInscripcion: LocalDate
    ) {

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

                jugadorRepository.insertar(
                    JugadorEntity(
                        id = personaId,
                        nombreAcudiente = nombreAcudiente,
                        diaInscripcion = diaInscripcion
                    )
                )

            } catch (e: Exception) {

                _uiState.value = _uiState.value.copy(
                    error = e.message
                )
            }
        }
    }
}