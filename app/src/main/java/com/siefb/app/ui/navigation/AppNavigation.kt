package com.siefb.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

import androidx.lifecycle.viewmodel.compose.viewModel

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

import com.siefb.app.SiefbApplication

import com.siefb.app.viewmodel.factory.AppViewModelFactory

import com.siefb.app.viewmodel.jugador.JugadorViewModel
import com.siefb.app.viewmodel.trabajador.TrabajadorViewModel

import com.siefb.app.ui.screens.home.HomeScreen

import com.siefb.app.ui.screens.jugadores.JugadorFormScreen
import com.siefb.app.ui.screens.jugadores.JugadorListScreen

import com.siefb.app.ui.screens.trabajadores.TrabajadorFormScreen
import com.siefb.app.ui.screens.trabajadores.TrabajadorListScreen

@Composable
fun AppNavigation() {

    val navController =
        rememberNavController()

    val application =
        LocalContext.current
            .applicationContext as SiefbApplication

    val jugadorViewModel: JugadorViewModel =
        viewModel(
            factory =
                AppViewModelFactory(
                    application
                )
        )

    val trabajadorViewModel:
            TrabajadorViewModel =
        viewModel(
            factory =
                AppViewModelFactory(
                    application
                )
        )

    NavHost(
        navController = navController,
        startDestination = Routes.Home.route
    ) {

        composable(
            Routes.Home.route
        ) {


            HomeScreen(

                onJugadoresClick = {

                    navController.navigate(
                        Routes.Jugadores.route
                    )
                },

                onTrabajadoresClick = {

                    navController.navigate(
                        Routes.Trabajadores.route
                    )
                }
            )
        }

        composable(
            Routes.Jugadores.route
        ) {

            JugadorListScreen(

                viewModel =
                    jugadorViewModel,

                onAgregarClick = {

                    navController.navigate(
                        Routes.JugadorForm
                            .createRoute()
                    )
                },

                onEditarClick = { jugadorId ->

                    navController.navigate(
                        Routes.JugadorForm
                            .createRoute(
                                jugadorId
                            )
                    )
                }
            )
        }

        composable(
            Routes.JugadorForm.route
        ) { backStackEntry ->

            val jugadorId =
                backStackEntry.arguments
                    ?.getString(
                        "jugadorId"
                    )
                    ?.toIntOrNull()
                    ?: -1

            JugadorFormScreen(

                jugadorId = jugadorId,

                viewModel =
                    jugadorViewModel,

                onGuardar = {

                    navController
                        .popBackStack()
                }
            )
        }

        composable(
            Routes.Trabajadores.route
        ) {

            TrabajadorListScreen(

                viewModel =
                    trabajadorViewModel,

                onAgregarClick = {

                    navController.navigate(
                        Routes.TrabajadorForm
                            .createRoute()
                    )
                },

                onEditarClick = {
                        trabajadorId ->

                    navController.navigate(
                        Routes.TrabajadorForm
                            .createRoute(
                                trabajadorId
                            )
                    )
                }
            )
        }

        composable(
            Routes.TrabajadorForm.route
        ) { backStackEntry ->

            val trabajadorId =
                backStackEntry.arguments
                    ?.getString(
                        "trabajadorId"
                    )
                    ?.toIntOrNull()
                    ?: -1

            TrabajadorFormScreen(

                trabajadorId =
                    trabajadorId,

                viewModel =
                    trabajadorViewModel,

                onGuardar = {

                    navController
                        .popBackStack()
                }
            )
        }
    }
}