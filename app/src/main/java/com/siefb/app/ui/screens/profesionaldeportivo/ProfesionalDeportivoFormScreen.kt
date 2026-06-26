package com.siefb.app.ui.screens.profesionaldeportivo


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.*

import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.siefb.app.viewmodel.profesionaldeportivo.ProfesionalDeportivoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfesionalDeportivoFormScreen(

    viewModel: ProfesionalDeportivoViewModel,

    onGuardar: () -> Unit

) {

    var trabajadorId by remember {

        mutableStateOf("")

    }

    Scaffold(

        topBar = {

            TopAppBar(

                title = {

                    Text("Nuevo Profesional Deportivo")

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

            OutlinedTextField(

                value = trabajadorId,

                onValueChange = {

                    trabajadorId = it

                },

                label = {

                    Text("ID Trabajador")

                }

            )

            Button(

                modifier = Modifier.fillMaxWidth(),

                onClick = {

                    trabajadorId.toIntOrNull()?.let {

                        viewModel.registrarProfesional(it)

                        onGuardar()

                    }

                }

            ) {

                Text("Guardar")

            }

        }

    }

}