package org.student.travelnoteapp.presentation.travel

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun TravelDetailsScreen(
    navController: NavController
) {

}

@Composable
@Preview(showBackground = true)
fun TravelDetailsScreenPreview() {
    TravelDetailsScreen(
        navController = rememberNavController()
    )
}