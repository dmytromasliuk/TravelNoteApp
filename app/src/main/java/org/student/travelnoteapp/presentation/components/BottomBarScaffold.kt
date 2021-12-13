package org.student.travelnoteapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun BottomBarScaffold(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier.fillMaxWidth(),
                backgroundColor = MaterialTheme.colors.primary
            ) {
                BottomNavigation(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    BottomNavItem(
                        icon = Icons.Default.List,
                        contentDescription = "Travel list",
                        selected = true,
                    ) {
                        
                    }
                    BottomNavItem(
                        icon = Icons.Default.LocationOn,
                        contentDescription = "Map",
                        selected = false,
                    ) {

                    }
                    BottomNavItem(
                        icon = Icons.Default.Person,
                        contentDescription = "Profile",
                        selected = false,
                    ) {

                    }
                }
            }
        },
        modifier = modifier
    ) {
        content()
    }
}