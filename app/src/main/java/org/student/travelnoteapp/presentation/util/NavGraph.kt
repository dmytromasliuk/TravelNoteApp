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
import org.student.travelnoteapp.presentation.travel.TravelDetailsScreen
import org.student.travelnoteapp.presentation.travel.TravelListScreen

@Composable
fun SetupNavGraph(
    navController: NavHostController
){
    NavHost(
        navController = navController,
        startDestination = Screen.Login.rout
    ){
        composable(
            route = Screen.Login.rout
        ){
            LoginScreen(navController = navController)
        }
        composable(
            route = Screen.Registration.rout
        ){
            RegistrationScreen(navController = navController)
        }
        composable(
            route = Screen.Profile.rout
        ){
            ProfileScreen(navController = navController)
        }
        composable(
            route = Screen.ProfileUpdate.rout
        ){
            ProfileUpdateScreen(navController = navController)
        }
        composable(
            route = Screen.TravelList.rout
        ){
            TravelListScreen(navController = navController)
        }
        composable(
            route = Screen.TravelDetails.rout
        ){
            TravelDetailsScreen(navController = navController)
        }
        composable(
            route = Screen.Map.rout
        ){
            MapScreen(navController = navController)
        }
    }
}