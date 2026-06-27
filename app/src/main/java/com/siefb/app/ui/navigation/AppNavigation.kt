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

import com.siefb.app.viewmodel.administrador.AdministradorViewModel

import com.siefb.app.ui.screens.administradores.AdministradorListScreen
import com.siefb.app.ui.screens.administradores.AdministradorFormScreen
import com.siefb.app.viewmodel.profesionaldeportivo.ProfesionalDeportivoViewModel
import com.siefb.app.ui.screens.profesionaldeportivo.ProfesionalDeportivoListScreen
import com.siefb.app.ui.screens.profesionaldeportivo.ProfesionalDeportivoFormScreen
import com.siefb.app.viewmodel.entrenamiento.EntrenamientoViewModel
import com.siefb.app.ui.screens.entrenamiento.EntrenamientoListScreen
import com.siefb.app.ui.screens.entrenamiento.EntrenamientoFormScreen
import com.siefb.app.ui.screens.partido.PartidoListScreen
import com.siefb.app.viewmodel.partido.PartidoViewModel
import com.siefb.app.ui.screens.partido.PartidoFormScreen
import com.siefb.app.ui.screens.registrocontable.RegistroContableFormScreen
import com.siefb.app.ui.screens.registrocontable.RegistroContableListScreen

import com.siefb.app.viewmodel.registrocontable.RegistroContableViewModel

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

    val administradorViewModel:
            AdministradorViewModel =
        viewModel(
            factory =
                AppViewModelFactory(
                    application
                )
        )

    val profesionalViewModel:
            ProfesionalDeportivoViewModel =
        viewModel(
            factory =
                AppViewModelFactory(application)
        )

    val entrenamientoViewModel:

            EntrenamientoViewModel =

        viewModel(

            factory =
                AppViewModelFactory(application)

        )

    val partidoViewModel: PartidoViewModel =
        viewModel(
            factory = AppViewModelFactory(application)
        )

    val registroContableViewModel: RegistroContableViewModel =
        viewModel(
            factory = AppViewModelFactory(application)
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
                },
                onAdministradoresClick = {
                    navController.navigate(
                        Routes.Administradores.route
                    )
                },

                onProfesionalesClick = {
                    navController.navigate(
                        Routes.ProfesionalesDeportivos.route
                    )
                },
                onEntrenamientosClick = {

                    navController.navigate(

                        Routes.Entrenamientos.route

                    )

                },
                onPartidosClick = {

                    navController.navigate(
                        Routes.Partidos.route
                    )

                },
                onRegistrosContablesClick = {

                    navController.navigate(
                        Routes.RegistrosContables.route
                    )

                },


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

        composable(
            Routes.Administradores.route
        ) {

            AdministradorListScreen(

                viewModel =
                    administradorViewModel,

                onAgregarClick = {

                    navController.navigate(
                        Routes.AdministradorForm.route
                    )
                }
            )
        }

        composable(
            Routes.AdministradorForm.route
        ) {

            AdministradorFormScreen(

                viewModel =
                    administradorViewModel,

                onGuardar = {

                    navController.popBackStack()
                }
            )
        }

        composable(
            Routes.ProfesionalesDeportivos.route
        ) {

            ProfesionalDeportivoListScreen(

                viewModel = profesionalViewModel,

                onAgregarClick = {

                    navController.navigate(
                        Routes.ProfesionalDeportivoForm.route
                    )
                }
            )
        }

        composable(
            Routes.ProfesionalDeportivoForm.route
        ) {

            ProfesionalDeportivoFormScreen(

                viewModel = profesionalViewModel,

                onGuardar = {

                    navController.popBackStack()
                }
            )
        }

        composable(

            Routes.Entrenamientos.route

        ) {

            EntrenamientoListScreen(

                viewModel = entrenamientoViewModel,

                onAgregarClick = {

                    navController.navigate(
                        Routes.EntrenamientoForm.createRoute()
                    )

                },

                onEditarClick = { entrenamientoId ->

                    navController.navigate(
                        Routes.EntrenamientoForm.createRoute(
                            entrenamientoId
                        )
                    )

                }

            )
        }
        composable(

            Routes.EntrenamientoForm.route

        ) {

                backStackEntry ->

            val entrenamientoId =

                backStackEntry.arguments

                    ?.getString(
                        "entrenamientoId"
                    )

                    ?.toIntOrNull()

                    ?: -1

            EntrenamientoFormScreen(

                entrenamientoId = entrenamientoId,

                viewModel = entrenamientoViewModel,

                onGuardar = {

                    navController.popBackStack()

                }

            )

        }

        composable(
            Routes.Partidos.route
        ) {

            PartidoListScreen(

                viewModel = partidoViewModel,

                onAgregarClick = {

                    navController.navigate(
                        Routes.PartidoForm.createRoute()
                    )

                },

                onEditarClick = { partidoId ->

                    navController.navigate(
                        Routes.PartidoForm.createRoute(
                            partidoId
                        )
                    )

                }

            )

        }

        composable(
            Routes.PartidoForm.route
        ) { backStackEntry ->

            val partidoId =
                backStackEntry.arguments
                    ?.getString("partidoId")
                    ?.toIntOrNull()
                    ?: -1

            PartidoFormScreen(

                partidoId = partidoId,

                viewModel = partidoViewModel,

                onGuardar = {

                    navController.popBackStack()

                }

            )

        }

        composable(
            Routes.RegistrosContables.route
        ) {

            RegistroContableListScreen(

                viewModel = registroContableViewModel,

                onAgregarClick = {

                    navController.navigate(
                        Routes.RegistroContableForm.createRoute()
                    )

                },

                onEditarClick = { registroId ->

                    navController.navigate(
                        Routes.RegistroContableForm.createRoute(
                            registroId
                        )
                    )

                }
            )

        }
        composable(
            Routes.RegistroContableForm.route
        ) { backStackEntry ->

            val registroId =
                backStackEntry.arguments
                    ?.getString("registroId")
                    ?.toIntOrNull()
                    ?: -1

            RegistroContableFormScreen(

                registroId = registroId,

                viewModel = registroContableViewModel,

                onGuardar = {

                    navController.popBackStack()

                }

            )

        }


    }
}