package org.student.travelnoteapp.ui.screens

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.compose.rememberNavController

@Composable
fun MapScreen(
    navController: NavController
) {
    Scaffold(
        bottomBar = {}
    ) {

    }

}

@Composable
@Preview(showBackground = true)
fun MapScreenPreview() {
    MapScreen(
        navController = rememberNavController()
    )
}