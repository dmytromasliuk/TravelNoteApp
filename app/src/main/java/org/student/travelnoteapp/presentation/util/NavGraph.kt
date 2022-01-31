package org.student.travelnoteapp.presentation.util

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import org.student.travelnoteapp.presentation.login.LoginScreen
import org.student.travelnoteapp.presentation.profile.ProfileScreen
import org.student.travelnoteapp.presentation.profile.ProfileUpdateScreen
import org.student.travelnoteapp.presentation.registration.RegistrationScreen
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
            route = Screen.CurrentTravelTimetable.route
        ){
            CurrentTravelTimetableScreen(navController = navController)
        }

    }
}