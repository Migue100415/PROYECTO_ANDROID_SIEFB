package com.siefb.app.ui.screens.trabajadores

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.siefb.app.viewmodel.trabajador.TrabajadorViewModel

import java.time.LocalDate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrabajadorFormScreen(
    trabajadorId: Int,
    viewModel: TrabajadorViewModel,
    onGuardar: () -> Unit
) {

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(trabajadorId) {
        viewModel.cargarTrabajador(trabajadorId)
    }

    var documento by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var arl by remember { mutableStateOf("") }

    LaunchedEffect(
        uiState.trabajadorSeleccionado
    ) {

        uiState.trabajadorSeleccionado?.let {

            documento = it.persona.documento
            nombre = it.persona.nombre
            direccion = it.persona.direccion
            telefono = it.persona.telefono
            arl = it.trabajador.arl
        }
    }

    Scaffold(

        topBar = {

            TopAppBar(
                title = {

                    Text(
                        if (trabajadorId == -1)
                            "Nuevo Trabajador"
                        else
                            "Editar Trabajador"
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
                value = documento,
                onValueChange = {
                    documento = it
                },
                label = {
                    Text("Documento")
                }
            )

            OutlinedTextField(
                value = nombre,
                onValueChange = {
                    nombre = it
                },
                label = {
                    Text("Nombre")
                }
            )

            OutlinedTextField(
                value = direccion,
                onValueChange = {
                    direccion = it
                },
                label = {
                    Text("Dirección")
                }
            )

            OutlinedTextField(
                value = telefono,
                onValueChange = {
                    telefono = it
                },
                label = {
                    Text("Teléfono")
                }
            )

            OutlinedTextField(
                value = arl,
                onValueChange = {
                    arl = it
                },
                label = {
                    Text("ARL")
                }
            )

            Button(
                onClick = {

                    if (trabajadorId == -1) {

                        viewModel.registrarTrabajador(
                            documento = documento,
                            nombre = nombre,
                            direccion = direccion,
                            telefono = telefono,
                            actaMedica = "",
                            eps = "",
                            foto = "",
                            fechaNacimiento = LocalDate.now(),
                            arl = arl,
                            diaIngreso = LocalDate.now()
                        )

                    } else {

                        viewModel.actualizarTrabajador(
                            id = trabajadorId,
                            documento = documento,
                            nombre = nombre,
                            direccion = direccion,
                            telefono = telefono,
                            actaMedica = "",
                            eps = "",
                            foto = "",
                            fechaNacimiento = LocalDate.now(),
                            arl = arl,
                            diaIngreso = LocalDate.now()
                        )
                    }

                    onGuardar()
                },
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    if (trabajadorId == -1)
                        "Guardar"
                    else
                        "Actualizar"
                )
            }
        }
    }
}