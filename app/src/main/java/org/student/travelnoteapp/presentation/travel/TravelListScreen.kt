package org.student.travelnoteapp.presentation.travel

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.student.travelnoteapp.presentation.components.BottomBarScaffold

@Composable
fun TravelListScreen(
    navController: NavController
) {

    BottomBarScaffold () {

    }
}

@Composable
@Preview(showBackground = true)
fun TravelListScreenPreview() {
    TravelListScreen(
        navController = rememberNavController()
    )
}