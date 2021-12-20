package org.student.travelnoteapp.data.remote.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.FormatListBulleted
import androidx.compose.material.icons.outlined.Map
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import org.student.travelnoteapp.presentation.util.Screen

sealed class BottomNavItem(
    val route: String,
    val contentDescription: String? = null,
    val icon: ImageVector
) {
    object TravelList: BottomNavItem(
        route = Screen.TravelList.route,
        contentDescription = "Travel list",
        icon = Icons.Outlined.FormatListBulleted
    )
    object CurrentTravelTimetable: BottomNavItem(
        route = Screen.CurrentTravelTimetable.route,
        contentDescription = "Current travel timetable",
        icon = Icons.Outlined.AccessTime
    )
    object Map: BottomNavItem(
        route = Screen.Map.route,
        contentDescription = "Map",
        icon = Icons.Outlined.Map
    )
    object Profile: BottomNavItem(
        route = Screen.Profile.route,
        contentDescription = "Profile",
        icon = Icons.Outlined.Person
    )
}
