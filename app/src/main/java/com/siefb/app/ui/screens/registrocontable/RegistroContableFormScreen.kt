package com.siefb.app.ui.screens.registrocontable


import androidx.compose.foundation.layout.*

import androidx.compose.material3.*

import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.siefb.app.data.enums.TipoMovimiento
import com.siefb.app.viewmodel.registrocontable.RegistroContableViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroContableFormScreen(

    registroId: Int,

    viewModel: RegistroContableViewModel,

    onGuardar: () -> Unit

) {

    val uiState by viewModel.uiState.collectAsState()

    var fecha by remember { mutableStateOf("") }

    var cantidad by remember { mutableStateOf("") }

    var comprobante by remember { mutableStateOf("") }

    var tipo by remember { mutableStateOf("") }

    var administradorId by remember { mutableStateOf("") }

    LaunchedEffect(registroId) {

        if (registroId != -1)

            viewModel.cargarRegistro(
                registroId
            )

    }

    LaunchedEffect(uiState.registroSeleccionado) {

        uiState.registroSeleccionado?.let {

            fecha = it.fecha

            cantidad = it.cantidadPago.toString()

            comprobante = it.comprobante

            tipo = it.tipo.name

            administradorId =
                it.administradorId.toString()

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

            modifier =
                Modifier
                    .padding(padding)
                    .padding(16.dp),

            verticalArrangement =
                Arrangement.spacedBy(12.dp)

        ) {

            OutlinedTextField(
                value = fecha,
                onValueChange = { fecha = it },
                label = { Text("Fecha") }
            )

            OutlinedTextField(
                value = cantidad,
                onValueChange = { cantidad = it },
                label = { Text("Cantidad") }
            )

            OutlinedTextField(
                value = comprobante,
                onValueChange = { comprobante = it },
                label = { Text("Comprobante") }
            )

            OutlinedTextField(
                value = tipo,
                onValueChange = { tipo = it.uppercase() },
                label = { Text("ENTRADA o SALIDA") }
            )

            OutlinedTextField(
                value = administradorId,
                onValueChange = { administradorId = it },
                label = { Text("Administrador ID") }
            )

            Button(

                modifier =
                    Modifier.fillMaxWidth(),

                onClick = {

                    val movimiento =

                        TipoMovimiento.valueOf(
                            tipo
                        )

                    if (registroId == -1) {

                        viewModel.registrarRegistro(

                            fecha,

                            cantidad.toInt(),

                            comprobante,

                            movimiento,

                            administradorId.toInt()

                        )

                    } else {

                        viewModel.actualizarRegistro(

                            registroId,

                            fecha,

                            cantidad.toInt(),

                            comprobante,

                            movimiento,

                            administradorId.toInt()

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