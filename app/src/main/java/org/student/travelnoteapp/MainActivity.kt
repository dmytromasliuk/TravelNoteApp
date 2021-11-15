package org.student.travelnoteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.student.travelnoteapp.data.remote.services.RegistrationService
import org.student.travelnoteapp.ui.screens.SetupNavGraph
import org.student.travelnoteapp.ui.theme.TravelNoteAppTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val service = RegistrationService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            TravelNoteAppTheme {
                navController = rememberNavController()
                SetupNavGraph(navController = navController)
            }
        }
    }
}