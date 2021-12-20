package org.student.travelnoteapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.student.travelnoteapp.data.remote.models.BottomNavItem
import org.student.travelnoteapp.presentation.util.Screen

@Composable
fun BottomBarScaffold(
    modifier: Modifier = Modifier,
    navController: NavController,
    bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem.TravelList,
        BottomNavItem.CurrentTravelTimetable,
        BottomNavItem.Map,
        BottomNavItem.Profile
    ),
    showBottomBar: Boolean = true,
    content: @Composable () -> Unit
) {

    Scaffold(
        bottomBar = {
            if (showBottomBar) {
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
                    BottomNavigation {
                        bottomNavItems.forEachIndexed { _, bottomNavItem ->
                            BottomNavItem(
                                icon = bottomNavItem.icon,
                                contentDescription = bottomNavItem.contentDescription,
                                selected = bottomNavItem.route == navController.currentDestination?.route,
                            ){
                                navController.navigate(bottomNavItem.route){
                                    popUpTo(Screen.TravelList.route){
                                        inclusive = true
                                    }
                                }
                            }
                        }
                    }
                }
            }
        },
        modifier = modifier
    ) {
        content()
    }
}