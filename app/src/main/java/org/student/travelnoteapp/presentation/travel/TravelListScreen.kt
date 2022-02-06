package org.student.travelnoteapp.presentation.travel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.student.travelnoteapp.data.room.model.Travel
import org.student.travelnoteapp.data.room.model.relations.TravelWithAllInfo
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

        //TravelList(, navController)
        val travels: List<TravelWithAllInfo> = viewModel.travels.observeAsState(listOf()).value
        LazyColumn(
            contentPadding = PaddingValues(
                start = 6.dp,
                end = 6.dp,
                top = 6.dp,
                bottom = 60.dp
            ),
            verticalArrangement = Arrangement.spacedBy(7.dp),
        ) {
            items(travels) { travel ->
                TravelListItem(travel = travel, navController = navController)
            }
        }

    }
}

@Composable
fun TravelList(travelList: Unit, navController: NavController) {

}


//@Composable
//@Preview(showBackground = true)
//fun TravelListScreenPreview() {
//    TravelListScreen(
//        navController = rememberNavController()
//    )
//}