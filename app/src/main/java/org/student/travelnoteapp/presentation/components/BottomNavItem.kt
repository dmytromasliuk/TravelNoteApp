package org.student.travelnoteapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.ui.graphics.Color
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.FormatListBulleted
import androidx.compose.material.icons.outlined.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import org.student.travelnoteapp.presentation.util.Screen

@Composable
fun RowScope.BottomNavItem(
    modifier : Modifier = Modifier,
    selected : Boolean = false,
    enabled : Boolean = true,
    icon : ImageVector,
    contentDescription : String? = null,
    selectedColor : Color = MaterialTheme.colors.background,
    unselectedColor : Color = MaterialTheme.colors.onPrimary,
    onClick: () -> Unit
) {

    BottomNavigationItem(
        selected = selected,
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        selectedContentColor = selectedColor,
        unselectedContentColor = unselectedColor,
        icon = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    //.padding(SpaceSmall)
                    .drawBehind {
                        if (selected) {
                            drawLine(
                                color = if (selected)
                                    selectedColor
                                else
                                    unselectedColor,
                                start = Offset(size.width / 2, size.height),
                                end = Offset(size.width / 2, size.height),
                                strokeWidth = 3.dp.toPx(),
                                cap = StrokeCap.Round
                            )
                        }
                    }
            ) {
                Icon(
                    imageVector = icon,
                    contentDescription = contentDescription,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(bottom = 3.dp)
                )
            }
        }
    )
}

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
    object Profile: BottomNavItem(
        route = Screen.Profile.route,
        contentDescription = "Profile",
        icon = Icons.Outlined.Person
    )
}