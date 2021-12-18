package org.student.travelnoteapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.Scaffold
import dagger.hilt.android.AndroidEntryPoint
import org.student.travelnoteapp.data.remote.services.RegistrationService
import org.student.travelnoteapp.presentation.ui.theme.TravelNoteAppTheme
import org.student.travelnoteapp.presentation.util.NavGraph

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val service = RegistrationService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelNoteAppTheme {
                Scaffold() {
                    navController = rememberNavController()
                    NavGraph(navController = navController)
                }
            }
        }
    }
}