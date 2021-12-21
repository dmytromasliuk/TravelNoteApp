package org.student.travelnoteapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import org.student.travelnoteapp.data.remote.models.BottomNavItem
import org.student.travelnoteapp.data.remote.services.RegistrationService
import org.student.travelnoteapp.presentation.components.MainScaffold
import org.student.travelnoteapp.presentation.ui.theme.TravelNoteAppTheme
import org.student.travelnoteapp.presentation.util.NavGraph
import org.student.travelnoteapp.presentation.util.Screen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController
    private val service = RegistrationService.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TravelNoteAppTheme {
                val systemUiController = rememberSystemUiController()
                //systemUiController.isStatusBarVisible = false
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colors.background)
                ){
                    navController = rememberNavController()
                    val navBackStackEntry by navController.currentBackStackEntryAsState()
                    MainScaffold(
                        modifier = Modifier.fillMaxSize(),
                        navController = navController,

                        showBottomBar = navBackStackEntry?.destination?.route in listOf(
                            BottomNavItem.TravelList.route,
                            BottomNavItem.CurrentTravelTimetable.route,
                            BottomNavItem.Map.route,
                            BottomNavItem.Profile.route
                        ),
                        showTopBar = navBackStackEntry?.destination?.route in listOf(
                            BottomNavItem.TravelList.route,
                            BottomNavItem.CurrentTravelTimetable.route,
                            BottomNavItem.Map.route,
                            BottomNavItem.Profile.route
                        )
                    ) {
                        NavGraph(navController = navController)
                    }
                }
            }
        }
    }
}