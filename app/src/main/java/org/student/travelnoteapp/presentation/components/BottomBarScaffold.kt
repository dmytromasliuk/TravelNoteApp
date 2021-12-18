package org.student.travelnoteapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.student.travelnoteapp.presentation.util.Screen

@Composable
fun BottomBarScaffold(
    navController: NavController,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    Scaffold(
        bottomBar = {
            BottomAppBar(
                backgroundColor = MaterialTheme.colors.primary,
                elevation = 15.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(22.dp)
                    .graphicsLayer {
                        shape = RoundedCornerShape(
                            15.dp
                        )
                        clip = true
                    }
            ) {
                BottomNavigation(
//                    modifier = Modifier
//                        .fillMaxWidth()
                ) {
                    BottomNavItem(
                        icon = Icons.Rounded.FormatListBulleted,
                        contentDescription = "Travel list",
                        selected = true,
                        onClick = {
                            navController.navigate(Screen.TravelList.route){
                                popUpTo(Screen.TravelList.route){
                                    inclusive = true
                                }
                            }
                        }
                    )
                    BottomNavItem(
                        icon = Icons.Rounded.AccessTime,
                        contentDescription = "Current travel timetable",
                        selected = false,
                        onClick = {
                            navController.navigate(Screen.CurrentTravelTimetable.route){
                                popUpTo(Screen.CurrentTravelTimetable.route){
                                    inclusive = true
                                }
                            }
                        }
                    )
                    BottomNavItem(
                        icon = Icons.Rounded.Map,
                        contentDescription = "Map",
                        selected = false,
                        onClick = {
                            navController.navigate(Screen.Map.route){
                                popUpTo(Screen.Map.route){
                                    inclusive = true
                                }
                            }
                        }
                    )
                    BottomNavItem(
                        icon = Icons.Rounded.Person,
                        contentDescription = "Profile",
                        selected = false,
                        onClick = {
                            navController.navigate(Screen.Profile.route){
                                popUpTo(Screen.Profile.route){
                                    inclusive = true
                                }
                            }
                        }
                    )
                }
            }
        },
        modifier = modifier
    ) {
        content()
    }
}