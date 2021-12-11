package org.student.travelnoteapp.presentation.profile

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileUpdateScreen(
    navController: NavController
) {

}

@Composable
@Preview(showBackground = true)
fun ProfileUpdateScreenPreview() {
    ProfileScreen(
        navController = rememberNavController()
    )
}