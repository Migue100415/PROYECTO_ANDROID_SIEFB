package com.siefb.app.ui.screens.entrenamiento


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

import com.siefb.app.viewmodel.entrenamiento.EntrenamientoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntrenamientoFormScreen(

    entrenamientoId: Int,

    viewModel: EntrenamientoViewModel,

    onGuardar: () -> Unit

) {

    val uiState by viewModel.uiState.collectAsState()

    var fecha by remember {

        mutableStateOf("")

    }

    var observaciones by remember {

        mutableStateOf("")

    }

    LaunchedEffect(
        entrenamientoId
    ) {

        if (entrenamientoId != -1) {

            viewModel.cargarEntrenamiento(
                entrenamientoId
            )

        }

    }

    LaunchedEffect(

        uiState.entrenamientoSeleccionado

    ) {

        uiState.entrenamientoSeleccionado?.let {

            fecha = it.fecha

            observaciones =
                it.observaciones ?: ""

        }

    }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text(

                        if (entrenamientoId == -1)

                            "Nuevo Entrenamiento"

                        else

                            "Editar Entrenamiento"

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

                onValueChange = {

                    fecha = it

                },

                label = {

                    Text("Fecha")

                },

                modifier =
                    Modifier.fillMaxWidth()

            )

            OutlinedTextField(

                value = observaciones,

                onValueChange = {

                    observaciones = it

                },

                label = {

                    Text("Observaciones")

                },

                modifier =
                    Modifier.fillMaxWidth()

            )

            Button(

                modifier =
                    Modifier.fillMaxWidth(),

                onClick = {

                    if (entrenamientoId == -1) {

                        viewModel
                            .registrarEntrenamiento(

                                fecha,

                                observaciones

                            )

                    } else {

                        viewModel
                            .actualizarEntrenamiento(

                                entrenamientoId,

                                fecha,

                                observaciones

                            )

                    }

                    onGuardar()

                }

            ) {

                Text(

                    if (entrenamientoId == -1)

                        "Guardar"

                    else

                        "Actualizar"

                )

            }

        }

    }

}