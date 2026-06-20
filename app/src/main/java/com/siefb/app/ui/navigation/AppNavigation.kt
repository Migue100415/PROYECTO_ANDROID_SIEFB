package com.siefb.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.*

import com.siefb.app.SiefbApplication
import com.siefb.app.viewmodel.factory.AppViewModelFactory
import com.siefb.app.viewmodel.jugador.JugadorViewModel
import com.siefb.app.ui.screens.home.HomeScreen
import com.siefb.app.ui.screens.jugadores.JugadorFormScreen
import com.siefb.app.ui.screens.jugadores.JugadorListScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    val application =
        LocalContext.current.applicationContext as SiefbApplication

    val jugadorViewModel: JugadorViewModel = viewModel(
        factory = AppViewModelFactory(application)
    )

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {

        composable(Routes.Home.route) {

            HomeScreen(
                onJugadoresClick = {
                    navController.navigate(
                        Routes.Jugadores.route
                    )
                }
            )
        }

        composable(Routes.Jugadores.route) {

            JugadorListScreen(
                viewModel = jugadorViewModel,
                onAgregarClick = {
                    navController.navigate(
                        Routes.NuevoJugador.route
                    )
                }
            )
        }

        composable(Routes.NuevoJugador.route) {

            JugadorFormScreen(
                viewModel = jugadorViewModel,
                onGuardar = {
                    navController.popBackStack()
                }
            )
        }
    }
}