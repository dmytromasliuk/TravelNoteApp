package org.student.travelnoteapp.presentation.util

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import org.student.travelnoteapp.presentation.booking.AddBookingScreen
import org.student.travelnoteapp.presentation.booking.BookingDetailsScreen
import org.student.travelnoteapp.presentation.booking.BookingEditScreen
import org.student.travelnoteapp.presentation.login.LoginScreen
import org.student.travelnoteapp.presentation.place.AddPlaceScreen
import org.student.travelnoteapp.presentation.place.PlaceDetailsScreen
import org.student.travelnoteapp.presentation.place.PlaceEditScreen
import org.student.travelnoteapp.presentation.profile.ProfileScreen
import org.student.travelnoteapp.presentation.profile.ProfileUpdateScreen
import org.student.travelnoteapp.presentation.registration.RegistrationScreen
import org.student.travelnoteapp.presentation.ticket.AddTicketScreen
import org.student.travelnoteapp.presentation.ticket.TicketDetailsScreen
import org.student.travelnoteapp.presentation.ticket.TicketEditScreen
import org.student.travelnoteapp.presentation.travel.*
import timber.log.Timber

@Composable
fun NavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.Login.route
    ){
        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navController = navController)
        }
        composable(
            route = Screen.Registration.route
        ){
            RegistrationScreen(navController = navController)
        }
        composable(
            route = Screen.Profile.route
        ){
            ProfileScreen(navController = navController)
        }
        composable(
            route = Screen.ProfileUpdate.route
        ){
            ProfileUpdateScreen(navController = navController)
        }
        composable(
            route = Screen.TravelList.route
        ){
            TravelListScreen(navController = navController)
        }
        composable(
            route = Screen.TravelDetails.route,
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ){
            it.arguments?.let { screen ->
                TravelDetailsScreen(
                    navController = navController,
                    id = screen.getInt("id")
                )
            }
        }
        composable(
            route = Screen.AddNewTravel.route
        ){
            AddNewTravelScreen(navController = navController)
        }
        composable(
            route = Screen.TravelEdit.route,
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ){
            it.arguments?.let { screen ->
                TravelEditScreen(navController = navController,
                id = screen.getInt("id")
                )
            }
        }
        composable(
            route = Screen.TicketDetails.route,
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ){
            it.arguments?.let { screen ->
                TicketDetailsScreen(navController = navController,
                    id = screen.getInt("id")
                )
            }
        }
        composable(
            route = Screen.AddTicket.route
        ){
            AddTicketScreen(navController = navController)
        }
        composable(
            route = Screen.TicketEdit.route,
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ){
            it.arguments?.let { screen ->
                TicketEditScreen(navController = navController,
                    id = screen.getInt("id")
                )
            }
        }
        composable(
            route = Screen.BookingDetails.route,
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ){
            it.arguments?.let { screen ->
                BookingDetailsScreen(navController = navController,
                    id = screen.getInt("id")
                )
            }
        }
        composable(
            route = Screen.AddBooking.route
        ){
            AddBookingScreen(navController = navController)
        }
        composable(
            route = Screen.BookingEdit.route,
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ){
            it.arguments?.let { screen ->
                BookingEditScreen(navController = navController,
                    id = screen.getInt("id")
                )
            }
        }
        composable(
            route = Screen.PlaceDetails.route,
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ){
            it.arguments?.let { screen ->
                PlaceDetailsScreen(navController = navController,
                    id = screen.getInt("id")
                )
            }
        }
        composable(
            route = Screen.AddPlace.route
        ){
            AddPlaceScreen(navController = navController)
        }
        composable(
            route = Screen.PlaceEdit.route,
            arguments = listOf(navArgument("id"){
                type = NavType.IntType
            })
        ){
            it.arguments?.let { screen ->
                PlaceEditScreen(navController = navController,
                    id = screen.getInt("id")
                )
            }
        }
        composable(
            route = Screen.CurrentTravelTimetable.route
        ){
            CurrentTravelTimetableScreen(navController = navController)
        }

    }
}