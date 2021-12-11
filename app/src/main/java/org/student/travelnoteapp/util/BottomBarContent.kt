package org.student.travelnoteapp.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarContent(
    val rout: String,
    val title: String,
    val icon: ImageVector
){
    object Map: BottomBarContent(
        rout = "map",
        title = "Map",
        icon = Icons.Default.Place
    )
    object Travels: BottomBarContent(
        rout = "travels",
        title = "Travels",
        icon = Icons.Default.List
    )
    object Profile: BottomBarContent(
        rout = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
}
