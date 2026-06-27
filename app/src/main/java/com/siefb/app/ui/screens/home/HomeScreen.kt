package com.siefb.app.ui.screens.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding

import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar

import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(

    onJugadoresClick: () -> Unit,

    onTrabajadoresClick: () -> Unit,

    onAdministradoresClick: () -> Unit,

    onProfesionalesClick: () -> Unit,

    onEntrenamientosClick: () -> Unit,

    onPartidosClick: () -> Unit,

    onRegistrosContablesClick: () -> Unit,

    onJugadorEntrenamientoClick: () -> Unit

) {

    Scaffold(

        topBar = {

            TopAppBar(
                title = {
                    Text("SIEFB")
                }
            )
        }

    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
        ) {

            Button(
                onClick = onJugadoresClick,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    "Gestión de Jugadores"
                )
            }

            Button(
                onClick = onTrabajadoresClick,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text(
                    "Gestión de Trabajadores"
                )
            }

            Button(
                onClick =
                    onAdministradoresClick,

                modifier =
                    Modifier.fillMaxWidth()
            ) {

                Text(
                    "Gestión de Administradores"
                )
            }

            Button(
                onClick = onProfesionalesClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Gestión de Profesionales Deportivos")
            }

            Button(

                onClick = onEntrenamientosClick,

                modifier = Modifier.fillMaxWidth()

            ) {

                Text(

                    "Gestión de Entrenamientos"

                )

            }

            Button(
                onClick = onPartidosClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Gestión de Partidos")
            }

            Button(
                onClick = onRegistrosContablesClick,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Gestión Registro Contable")

            }

            Button(
                onClick = onJugadorEntrenamientoClick,
                modifier = Modifier.fillMaxWidth()
            ) {

                Text("Jugador - Entrenamiento")

            }

        }
    }
}