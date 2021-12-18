package org.student.travelnoteapp.presentation.util

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import org.student.travelnoteapp.presentation.login.LoginScreen
import org.student.travelnoteapp.presentation.map.MapScreen
import org.student.travelnoteapp.presentation.profile.ProfileScreen
import org.student.travelnoteapp.presentation.profile.ProfileUpdateScreen
import org.student.travelnoteapp.presentation.registration.RegistrationScreen
import org.student.travelnoteapp.presentation.travel.CurrentTravelTimetableScreen
import org.student.travelnoteapp.presentation.travel.TravelDetailsScreen
import org.student.travelnoteapp.presentation.travel.TravelListScreen

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
            route = Screen.TravelDetails.route
        ){
            TravelDetailsScreen(navController = navController)
        }
        composable(
            route = Screen.CurrentTravelTimetable.route
        ){
            CurrentTravelTimetableScreen(navController = navController)
        }
        composable(
            route = Screen.Map.route
        ){
            MapScreen(navController = navController)
        }
    }
}