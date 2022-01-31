package org.student.travelnoteapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.R
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.student.travelnoteapp.presentation.components.BottomNavItem
import org.student.travelnoteapp.presentation.util.Screen

@Composable
fun MainScaffold(
    modifier: Modifier = Modifier,
    navController: NavController,
    bottomNavItems: List<BottomNavItem> = listOf(
        BottomNavItem.TravelList,
        BottomNavItem.CurrentTravelTimetable,
        BottomNavItem.Profile
    ),
    topBarTitle: String? = null,
    showTopBar: Boolean = true,
    showBottomBar: Boolean = true,
    showFloatingActionButton: Boolean = true,
    content: @Composable () -> Unit
) {

    Scaffold(
        topBar = {
            if (showTopBar) {
                TopAppBar(
                    //modifier = Modifier.height(40.dp),
                    contentColor = MaterialTheme.colors.onBackground,
                    elevation = 5.dp,
                    title = {
                        if (topBarTitle != null){
                            Text(
                                text = topBarTitle,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                )
            }
        },
        bottomBar = {
            if (showBottomBar) {
                BottomAppBar(
                    backgroundColor = MaterialTheme.colors.primary,
                    elevation = 15.dp,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    BottomNavigation {
                        bottomNavItems.forEachIndexed { _, bottomNavItem ->
                            BottomNavItem(
                                icon = bottomNavItem.icon,
                                contentDescription = bottomNavItem.contentDescription,
                                selected = bottomNavItem.route == navController.currentDestination?.route,

                            ){
                                navController.navigate(bottomNavItem.route){
                                    launchSingleTop = true
                                    popUpTo(BottomNavItem.TravelList.route)
                                }
                            }
                        }
                    }
                }
            }
        },
        floatingActionButton = {
            if (showFloatingActionButton){
                FloatingActionButton(
                    onClick = {
                        navController.navigate(Screen.AddNewTravel.route)
                    },
                    backgroundColor = MaterialTheme.colors.primary,
                    content = {
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = null,
                            tint = MaterialTheme.colors.background
                        )
                    }
                )
            }
        },
        modifier = modifier
    ) {
        content()
    }
}