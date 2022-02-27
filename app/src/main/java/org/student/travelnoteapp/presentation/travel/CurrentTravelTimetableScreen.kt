package org.student.travelnoteapp.presentation.travel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.student.travelnoteapp.presentation.components.TimetableListItem
import org.student.travelnoteapp.presentation.util.TimetableItemModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CurrentTravelTimetableScreen(
    navController: NavController,
    viewModel: CurrentTravelTimetableViewModel = hiltViewModel()
) {

    val travel = viewModel.travel.observeAsState().value
    val items = mutableListOf<TimetableItemModel>()
    val dates = mutableListOf<String>()

    travel?.tickets?.forEach {
        items.add(
            TimetableItemModel(
                it.date,
                it.time,
                "to ${it.destinationTo}")
        )
        dates.add(it.date)
    }
    travel?.places?.forEach {
        items.add(
            TimetableItemModel(
                it.date,
                it.time,
                it.title)
        )
        if (!dates.contains(it.date)) dates.add(it.date)
    }
    dates.sort()
    items.sortBy { it.times }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(55.dp)
                    .background(MaterialTheme.colors.primary),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${travel?.travel?.name} timetable",
                    color = MaterialTheme.colors.background,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }
        }

        Box(modifier = Modifier
            .fillMaxSize()
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(MaterialTheme.colors.background),
                reverseLayout = false,
                //verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                dates.forEach { date ->
                    stickyHeader {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            elevation = 5.dp,
                            backgroundColor = MaterialTheme.colors.secondary
                        ) {
                            Row(
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    modifier = Modifier.padding(8.dp),
                                    text = date,
                                    color = MaterialTheme.colors.onSecondary,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = MaterialTheme.typography.body1.fontSize
                                )
                            }
                        }
                    }
                    items(items){ item ->
                        if (item.date == date){
                            TimetableListItem(time = item.times, description = item.description)
                        }
                    }
                }
            }
        }
    }
}
