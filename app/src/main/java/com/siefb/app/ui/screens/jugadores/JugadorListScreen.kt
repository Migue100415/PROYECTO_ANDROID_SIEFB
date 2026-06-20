package com.siefb.app.ui.screens.jugadores

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.siefb.app.viewmodel.jugador.JugadorViewModel

@Composable
fun JugadorListScreen(
    viewModel: JugadorViewModel,
    onAgregarClick: () -> Unit
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

            items(uiState.jugadores) { jugador ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                ) {

                    Text(
                        text = "ID: ${jugador.id}",
                        modifier = Modifier.padding(16.dp)
                    )
                }
            }
        }
    }
}