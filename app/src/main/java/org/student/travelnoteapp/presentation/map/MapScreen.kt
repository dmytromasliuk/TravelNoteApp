package org.student.travelnoteapp.presentation.map

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.student.travelnoteapp.presentation.components.BottomBarScaffold

@Composable
fun MapScreen(
    navController: NavController
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            modifier = Modifier.padding(bottom = 25.dp),
            text = "Map",
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h4.fontSize
        )

        BottomBarScaffold (navController = navController) {

        }
    }



}

@Composable
@Preview(showBackground = true)
fun MapScreenPreview() {
    MapScreen(
        navController = rememberNavController()
    )
}