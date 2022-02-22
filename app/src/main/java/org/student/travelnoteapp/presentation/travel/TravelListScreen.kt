package org.student.travelnoteapp.presentation.travel

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.navigation.NavController
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.student.travelnoteapp.data.room.model.Travel
import org.student.travelnoteapp.data.room.model.relations.TravelWithAllInfo
import org.student.travelnoteapp.presentation.components.TravelListItem
import org.student.travelnoteapp.presentation.util.Screen

@Composable
fun TravelListScreen(
    navController: NavController,
    viewModel: TravelListViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier.fillMaxSize(),
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
                    text = "Travel list",
                    color = MaterialTheme.colors.background,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }
        }

        var starColor: Color
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
                starColor = if (travel.travel.isCurrent) MaterialTheme.colors.primary
                else MaterialTheme.colors.background
                Row(
                    modifier = Modifier
                        .background(MaterialTheme.colors.secondary)
                        .fillMaxWidth()
                        .padding(20.dp)
                        .selectable(
                            selected = true,
                            onClick = {
                                navController.navigate("travel_details_screen/" + travel.travel.id)
                            }
                        ),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Text(
                            text = travel.travel.name,
                            color = MaterialTheme.colors.primary,
                            fontSize = MaterialTheme.typography.body1.fontSize,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column {
                        Row(verticalAlignment = Alignment.CenterVertically){
                            Text(
                                text = travel.travel.description,
                                color = MaterialTheme.colors.primaryVariant,
                                fontSize = MaterialTheme.typography.body1.fontSize,
                                fontWeight = FontWeight.Normal,
                                modifier = Modifier.padding(end = 10.dp)
                            )
                            IconButton(
                                onClick = {
                                    viewModel.setSelectedTravel(travel.travel.id)
                                    viewModel.updateCurrentTravel(viewModel.selectedTravel.value, true)
                                    travels.forEach {
                                        if (it.travel.id != viewModel.selectedTravel.value){
                                            viewModel.updateCurrentTravel(it.travel.id, false)
                                        }
                                    }
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Star,
                                    contentDescription = "Set current travel icon",
                                    tint = starColor
                                )
                            }
                        }
                    }
                }
            }
        }

    }
}

