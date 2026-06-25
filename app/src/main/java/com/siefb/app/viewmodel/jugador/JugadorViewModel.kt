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
import com.siefb.app.data.relations.PersonaConJugador
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

            jugadorRepository.obtenerJugadoresCompletos()
                .collect { jugadores ->

                    _uiState.value = _uiState.value.copy(
                        jugadores = jugadores,
                        isLoading = false
                    )
                }
        }
    }

    fun cargarJugador(id: Int) {

        if (id == -1) return

        viewModelScope.launch {

            try {

                val persona =
                    personaRepository.obtenerPorId(id)

                val jugador =
                    jugadorRepository.obtenerPorId(id)

                if (persona != null && jugador != null) {

                    _uiState.value = _uiState.value.copy(
                        jugadorSeleccionado = PersonaConJugador(
                            persona = persona,
                            jugador = jugador
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
    )
    {

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

    fun eliminarJugador(persona: PersonaEntity) {

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

    fun actualizarJugador(
        id: Int,
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

                jugadorRepository.actualizar(
                    JugadorEntity(
                        id = id,
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