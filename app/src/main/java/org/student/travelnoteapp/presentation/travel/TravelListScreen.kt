package org.student.travelnoteapp.presentation.travel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.student.travelnoteapp.data.room.model.Travel
import org.student.travelnoteapp.presentation.components.TravelListItem

@Composable
fun TravelListScreen(
    navController: NavController,
    viewModel: TravelListViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            modifier = Modifier.padding(bottom = 25.dp),
            text = "Travel list",
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h4.fontSize
        )

        val travelList = viewModel.getAllTravels.value

        if (travelList != null) {
            TravelList(travelList = travelList, navController)
        }

    }
}

@Composable
fun TravelList(travelList: List<Travel>, navController: NavController) {
    LazyColumn(
        contentPadding = PaddingValues(
            start = 6.dp,
            end = 6.dp,
            top = 6.dp,
            bottom = 60.dp
        ),
        verticalArrangement = Arrangement.spacedBy(7.dp),
    ) {
        items(travelList) { travel ->
            TravelListItem(travel = travel, navController = navController)
        }
    }
}


//@Composable
//@Preview(showBackground = true)
//fun TravelListScreenPreview() {
//    TravelListScreen(
//        navController = rememberNavController()
//    )
//}