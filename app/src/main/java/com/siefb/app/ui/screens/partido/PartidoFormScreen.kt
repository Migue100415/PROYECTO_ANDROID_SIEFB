package com.siefb.app.ui.screens.partido


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

import com.siefb.app.viewmodel.partido.PartidoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PartidoFormScreen(

    partidoId: Int,

    viewModel: PartidoViewModel,

    onGuardar: () -> Unit

) {

    val uiState by viewModel.uiState.collectAsState()

    var fecha by remember { mutableStateOf("") }

    var arbitro by remember { mutableStateOf("") }

    var cancha by remember { mutableStateOf("") }

    var rival by remember { mutableStateOf("") }

    LaunchedEffect(partidoId) {

        if (partidoId != -1) {

            viewModel.cargarPartido(partidoId)

        }

    }

    LaunchedEffect(uiState.partidoSeleccionado) {

        uiState.partidoSeleccionado?.let {

            fecha = it.fecha

            arbitro = it.nombreArbitro

            cancha = it.nombreCancha

            rival = it.equipoRival

        }

    }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(

                        if (partidoId == -1)
                            "Nuevo Partido"
                        else
                            "Editar Partido"

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
                value = fecha,
                onValueChange = { fecha = it },
                label = { Text("Fecha") }
            )

            OutlinedTextField(
                value = arbitro,
                onValueChange = { arbitro = it },
                label = { Text("Árbitro") }
            )

            OutlinedTextField(
                value = cancha,
                onValueChange = { cancha = it },
                label = { Text("Cancha") }
            )

            OutlinedTextField(
                value = rival,
                onValueChange = { rival = it },
                label = { Text("Equipo Rival") }
            )

            Button(

                modifier = Modifier.fillMaxWidth(),

                onClick = {

                    if (partidoId == -1) {

                        viewModel.registrarPartido(

                            fecha,

                            arbitro,

                            cancha,

                            rival

                        )

                    } else {

                        viewModel.actualizarPartido(

                            partidoId,

                            fecha,

                            arbitro,

                            cancha,

                            rival

                        )

                    }

                    onGuardar()

                }

            ) {

                Text(

                    if (partidoId == -1)
                        "Guardar"
                    else
                        "Actualizar"

                )

            }

        }

    }

}