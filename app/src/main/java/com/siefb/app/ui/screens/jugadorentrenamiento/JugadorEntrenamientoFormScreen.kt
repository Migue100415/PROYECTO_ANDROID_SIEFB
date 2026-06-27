package com.siefb.app.ui.screens.jugadorentrenamiento

import androidx.compose.foundation.layout.*

import androidx.compose.material3.*

import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.siefb.app.viewmodel.jugadorentrenamiento.JugadorEntrenamientoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JugadorEntrenamientoFormScreen(

    registroId: Int,

    viewModel: JugadorEntrenamientoViewModel,

    onGuardar: () -> Unit

) {

    val uiState by viewModel.uiState.collectAsState()

    var jugadorId by remember { mutableStateOf("") }

    var entrenamientoId by remember { mutableStateOf("") }

    var asistencia by remember { mutableStateOf(false) }

    LaunchedEffect(registroId) {

        if (registroId != -1) {

            viewModel.cargarRegistro(registroId)

        }

    }

    LaunchedEffect(uiState.registroSeleccionado) {

        uiState.registroSeleccionado?.let {

            jugadorId = it.jugadorId.toString()

            entrenamientoId =
                it.entrenamientoId.toString()

            asistencia = it.asistencia

        }

    }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(

                        if (registroId == -1)

                            "Nuevo Registro"

                        else

                            "Editar Registro"

                    )

                }

            )

        }

    ) { padding ->

        Column(

            modifier = Modifier
                .padding(padding)
                .padding(16.dp),

            verticalArrangement =
                Arrangement.spacedBy(12.dp)

        ) {

            OutlinedTextField(

                value = jugadorId,

                onValueChange = {

                    jugadorId = it

                },

                label = {

                    Text("Jugador ID")

                }

            )

            OutlinedTextField(

                value = entrenamientoId,

                onValueChange = {

                    entrenamientoId = it

                },

                label = {

                    Text("Entrenamiento ID")

                }

            )

            Row {

                Checkbox(

                    checked = asistencia,

                    onCheckedChange = {

                        asistencia = it

                    }

                )

                Text("Asistencia")

            }

            Button(

                modifier =
                    Modifier.fillMaxWidth(),

                onClick = {

                    if (registroId == -1) {

                        viewModel.registrarRegistro(

                            jugadorId.toInt(),

                            entrenamientoId.toInt(),

                            asistencia

                        )

                    } else {

                        viewModel.actualizarRegistro(

                            registroId,

                            jugadorId.toInt(),

                            entrenamientoId.toInt(),

                            asistencia

                        )

                    }

                    onGuardar()

                }

            ) {

                Text(

                    if (registroId == -1)

                        "Guardar"

                    else

                        "Actualizar"

                )

            }

        }

    }

}