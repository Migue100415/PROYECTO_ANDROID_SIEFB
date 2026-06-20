package com.siefb.app.ui.screens.jugadores

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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.siefb.app.viewmodel.jugador.JugadorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun JugadorFormScreen(
    viewModel: JugadorViewModel,
    onGuardar: () -> Unit
) {

    var documento by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var acudiente by remember { mutableStateOf("") }

    Scaffold(

        topBar = {

            TopAppBar(
                title = {
                    Text("Nuevo jugador")
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
                value = acudiente,
                onValueChange = {
                    acudiente = it
                },
                label = {
                    Text("Acudiente")
                }
            )

            Button(
                onClick = {

                    viewModel.registrarJugador(
                        documento = documento,
                        nombre = nombre,
                        direccion = direccion,
                        telefono = telefono,
                        actaMedica = "",
                        eps = "",
                        foto = "",
                        fechaNacimiento = java.time.LocalDate.now(),
                        nombreAcudiente = acudiente,
                        diaInscripcion = java.time.LocalDate.now()
                    )

                    onGuardar()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }
        }
    }
}