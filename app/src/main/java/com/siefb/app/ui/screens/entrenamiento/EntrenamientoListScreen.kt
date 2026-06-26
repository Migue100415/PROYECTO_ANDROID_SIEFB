package com.siefb.app.ui.screens.entrenamiento

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit

import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import com.siefb.app.data.entities.EntrenamientoEntity
import com.siefb.app.viewmodel.entrenamiento.EntrenamientoViewModel

@Composable
fun EntrenamientoListScreen(

    viewModel: EntrenamientoViewModel,

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

                    imageVector = Icons.Default.Add,

                    contentDescription = "Agregar"

                )

            }

        }

    ) { padding ->

        LazyColumn(

            modifier = Modifier
                .padding(padding)
                .padding(16.dp)

        ) {

            items(
                uiState.entrenamientos
            ) { entrenamiento ->

                EntrenamientoItem(

                    entrenamiento = entrenamiento,

                    onEditarClick = {

                        onEditarClick(
                            entrenamiento.id
                        )

                    },

                    onEliminarClick = {

                        viewModel
                            .eliminarEntrenamiento(
                                entrenamiento
                            )

                    }

                )

            }

        }

    }

}

@Composable
private fun EntrenamientoItem(

    entrenamiento: EntrenamientoEntity,

    onEditarClick: () -> Unit,

    onEliminarClick: () -> Unit

) {

    Card(

        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)

    ) {

        Row(

            modifier = Modifier
                .padding(16.dp)

        ) {

            Column(

                modifier =
                    Modifier.weight(1f)

            ) {

                Text(
                    entrenamiento.fecha.toString()
                )

                Text(
                    entrenamiento.observaciones
                        ?: ""
                )

            }

            IconButton(

                onClick = onEditarClick

            ) {

                Icon(

                    Icons.Default.Edit,

                    contentDescription = "Editar"

                )

            }

            IconButton(

                onClick = onEliminarClick

            ) {

                Icon(

                    Icons.Default.Delete,

                    contentDescription = "Eliminar"

                )

            }

        }

    }

}