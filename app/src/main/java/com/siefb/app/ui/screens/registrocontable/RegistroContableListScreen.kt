package com.siefb.app.ui.screens.registrocontable

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

import com.siefb.app.viewmodel.registrocontable.RegistroContableViewModel

@Composable
fun RegistroContableListScreen(

    viewModel: RegistroContableViewModel,

    onAgregarClick: () -> Unit,

    onEditarClick: (Int) -> Unit

) {

    val uiState by viewModel.uiState.collectAsState()

    Scaffold(

        floatingActionButton = {

            FloatingActionButton(

                onClick = onAgregarClick

            ) {

                Icon(
                    Icons.Default.Add,
                    null
                )

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

                        modifier =
                            Modifier.padding(16.dp)

                    ) {

                        Column(

                            modifier =
                                Modifier.weight(1f)

                        ) {

                            Text(registro.fecha)

                            Text(
                                registro.tipo.name
                            )

                            Text(
                                "$ ${registro.cantidadPago}"
                            )

                            Text(
                                registro.comprobante
                            )

                            Text(
                                "Administrador: ${registro.administradorId}"
                            )

                        }

                        IconButton(

                            onClick = {

                                onEditarClick(
                                    registro.id
                                )

                            }

                        ) {

                            Icon(
                                Icons.Default.Edit,
                                null
                            )

                        }

                        IconButton(

                            onClick = {

                                viewModel.eliminarRegistro(
                                    registro
                                )

                            }

                        ) {

                            Icon(
                                Icons.Default.Delete,
                                null
                            )

                        }

                    }

                }

            }

        }

    }

}