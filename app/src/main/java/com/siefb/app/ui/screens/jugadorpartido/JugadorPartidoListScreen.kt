package com.siefb.app.ui.screens.jugadorpartido

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit

import androidx.compose.material3.*

import androidx.compose.runtime.*

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.siefb.app.viewmodel.jugadorpartido.JugadorPartidoViewModel

@Composable
fun JugadorPartidoListScreen(

    viewModel: JugadorPartidoViewModel,

    onAgregarClick: () -> Unit,

    onEditarClick: (Int) -> Unit

) {

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(

        floatingActionButton = {

            FloatingActionButton(
                onClick = onAgregarClick
            ) {
                Icon(Icons.Default.Add, null)
            }

        }

    ) { padding ->

        LazyColumn(

            modifier = Modifier
                .padding(padding)
                .padding(16.dp)

        ) {

            items(uiState.registros) { registro ->

                Card(

                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)

                ) {

                    Row(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Column(
                            modifier = Modifier.weight(1f)
                        ) {

                            Text("Jugador: ${registro.jugadorId}")
                            Text("Partido: ${registro.partidoId}")
                            Text("Goles: ${registro.goles}")
                            Text("Asistencias: ${registro.asistencias}")
                            Text("Amarillas: ${registro.amarillas}")
                            Text("Rojas: ${registro.rojas}")
                            Text(
                                if (registro.asistencia)
                                    "Asistió"
                                else
                                    "No asistió"
                            )

                        }

                        IconButton(
                            onClick = {
                                onEditarClick(registro.id)
                            }
                        ) {
                            Icon(Icons.Default.Edit, null)
                        }

                        IconButton(
                            onClick = {
                                viewModel.eliminarRegistro(registro)
                            }
                        ) {
                            Icon(Icons.Default.Delete, null)
                        }

                    }

                }

            }

        }

    }

}