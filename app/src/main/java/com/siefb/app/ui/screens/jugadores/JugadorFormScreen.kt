package com.siefb.app.ui.screens.jugadores

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.siefb.app.viewmodel.jugador.JugadorViewModel
import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JugadorFormScreen(
    jugadorId: Int,
    viewModel: JugadorViewModel,
    onGuardar: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    var documento by rememberSaveable { mutableStateOf("") }
    var nombre by rememberSaveable { mutableStateOf("") }
    var direccion by rememberSaveable { mutableStateOf("") }
    var telefono by rememberSaveable { mutableStateOf("") }
    var acudiente by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(jugadorId) {
        if (jugadorId != -1) {
            viewModel.cargarJugador(jugadorId)
        }
    }

    LaunchedEffect(uiState.jugadorSeleccionado) {

        uiState.jugadorSeleccionado?.let { jugadorCompleto ->

            documento = jugadorCompleto.persona.documento
            nombre = jugadorCompleto.persona.nombre
            direccion = jugadorCompleto.persona.direccion
            telefono = jugadorCompleto.persona.telefono
            acudiente = jugadorCompleto.jugador.nombreAcudiente
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        if (jugadorId == -1) {
                            "Nuevo jugador"
                        } else {
                            "Editar jugador"
                        }
                    )
                }
            )
        }
    ) { paddingValues ->

        if (uiState.isLoading && jugadorId != -1) {

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxWidth()
            ) {

                CircularProgressIndicator(
                    modifier = Modifier.padding(16.dp)
                )
            }

        } else {

            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState()),

                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                OutlinedTextField(
                    value = documento,
                    onValueChange = { documento = it },
                    label = { Text("Documento") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = nombre,
                    onValueChange = { nombre = it },
                    label = { Text("Nombre") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = direccion,
                    onValueChange = { direccion = it },
                    label = { Text("Dirección") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = telefono,
                    onValueChange = { telefono = it },
                    label = { Text("Teléfono") },
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = acudiente,
                    onValueChange = { acudiente = it },
                    label = { Text("Nombre del acudiente") },
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = {

                        if (jugadorId == -1) {

                            viewModel.registrarJugador(
                                documento = documento,
                                nombre = nombre,
                                direccion = direccion,
                                telefono = telefono,
                                actaMedica = "",
                                eps = "",
                                foto = "",
                                fechaNacimiento = LocalDate.now(),
                                nombreAcudiente = acudiente,
                                diaInscripcion = LocalDate.now()
                            )

                        } else {

                            viewModel.actualizarJugador(
                                id = jugadorId,
                                documento = documento,
                                nombre = nombre,
                                direccion = direccion,
                                telefono = telefono,
                                actaMedica = "",
                                eps = "",
                                foto = "",
                                fechaNacimiento = LocalDate.now(),
                                nombreAcudiente = acudiente,
                                diaInscripcion = LocalDate.now()
                            )
                        }

                        onGuardar()
                    },
                    modifier = Modifier.fillMaxWidth(),
                    enabled = documento.isNotBlank()
                            && nombre.isNotBlank()
                            && direccion.isNotBlank()
                            && telefono.isNotBlank()
                            && acudiente.isNotBlank()
                ) {

                    Text(
                        if (jugadorId == -1) {
                            "Guardar"
                        } else {
                            "Actualizar"
                        }
                    )
                }

                uiState.error?.let { mensajeError ->

                    Text(
                        text = mensajeError
                    )
                }
            }
        }
    }
}