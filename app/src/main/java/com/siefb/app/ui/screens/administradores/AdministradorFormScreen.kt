package com.siefb.app.ui.screens.administradores

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

import com.siefb.app.viewmodel.administrador.AdministradorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdministradorFormScreen(
    viewModel: AdministradorViewModel,
    onGuardar: () -> Unit
) {

    var trabajadorId by remember {
        mutableStateOf("")
    }

    Scaffold(

        topBar = {

            TopAppBar(
                title = {
                    Text(
                        "Nuevo Administrador"
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

                value = trabajadorId,

                onValueChange = {
                    trabajadorId = it
                },

                label = {
                    Text(
                        "ID Trabajador"
                    )
                }
            )

            Button(

                onClick = {

                    trabajadorId.toIntOrNull()
                        ?.let {

                            viewModel
                                .registrarAdministrador(
                                    it
                                )

                            onGuardar()
                        }
                },

                modifier =
                    Modifier.fillMaxWidth()
            ) {

                Text("Guardar")
            }
        }
    }
}