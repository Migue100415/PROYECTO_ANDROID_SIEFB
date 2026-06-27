package com.siefb.app.ui.screens.jugadorpartido

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.siefb.app.viewmodel.jugadorpartido.JugadorPartidoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JugadorPartidoFormScreen(

    registroId: Int,

    viewModel: JugadorPartidoViewModel,

    onGuardar: () -> Unit

) {

    val uiState by viewModel.uiState.collectAsState()

    var jugadorId by remember { mutableStateOf("") }
    var partidoId by remember { mutableStateOf("") }
    var goles by remember { mutableStateOf("") }
    var asistencias by remember { mutableStateOf("") }
    var amarillas by remember { mutableStateOf("") }
    var rojas by remember { mutableStateOf("") }
    var asistencia by remember { mutableStateOf(false) }

    LaunchedEffect(registroId) {
        if (registroId != -1)
            viewModel.cargarRegistro(registroId)
    }

    LaunchedEffect(uiState.registroSeleccionado) {

        uiState.registroSeleccionado?.let {

            jugadorId = it.jugadorId.toString()
            partidoId = it.partidoId.toString()
            goles = it.goles.toString()
            asistencias = it.asistencias.toString()
            amarillas = it.amarillas.toString()
            rojas = it.rojas.toString()
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

            verticalArrangement = Arrangement.spacedBy(12.dp)

        ) {

            OutlinedTextField(jugadorId, { jugadorId = it }, label = { Text("Jugador ID") })
            OutlinedTextField(partidoId, { partidoId = it }, label = { Text("Partido ID") })
            OutlinedTextField(goles, { goles = it }, label = { Text("Goles") })
            OutlinedTextField(asistencias, { asistencias = it }, label = { Text("Asistencias") })
            OutlinedTextField(amarillas, { amarillas = it }, label = { Text("Amarillas") })
            OutlinedTextField(rojas, { rojas = it }, label = { Text("Rojas") })

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

                modifier = Modifier.fillMaxWidth(),

                onClick = {

                    if (registroId == -1) {

                        viewModel.registrarRegistro(

                            jugadorId.toInt(),
                            partidoId.toInt(),
                            goles.toInt(),
                            asistencias.toInt(),
                            amarillas.toInt(),
                            rojas.toInt(),
                            asistencia

                        )

                    } else {

                        viewModel.actualizarRegistro(

                            registroId,
                            jugadorId.toInt(),
                            partidoId.toInt(),
                            goles.toInt(),
                            asistencias.toInt(),
                            amarillas.toInt(),
                            rojas.toInt(),
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