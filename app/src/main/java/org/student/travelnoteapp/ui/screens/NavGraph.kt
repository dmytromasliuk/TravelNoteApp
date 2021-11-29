package org.student.travelnoteapp.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

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
            ProfileScreen(navController = navController)
        }
        composable(
            route = Screen.TravelList.rout
        ){
            ProfileScreen(navController = navController)
        }
        composable(
            route = Screen.TravelDetails.rout
        ){
            ProfileScreen(navController = navController)
        }
        composable(
            route = Screen.Map.rout
        ){
            ProfileScreen(navController = navController)
        }
    }
}