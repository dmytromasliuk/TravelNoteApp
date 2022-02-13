package org.student.travelnoteapp.presentation.travel

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.student.travelnoteapp.data.room.model.Ticket
import org.student.travelnoteapp.presentation.components.BookingListItem
import org.student.travelnoteapp.presentation.components.PlaceListItem
import org.student.travelnoteapp.presentation.components.TicketListItem
import org.student.travelnoteapp.presentation.components.TravelDetailsItem
import org.student.travelnoteapp.presentation.util.Screen
import timber.log.Timber

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TravelDetailsScreen(
    navController: NavController,
    viewModel: TravelDetailsViewModel = hiltViewModel(),
    id: Int
) {

    val categories = listOf("Tickets","Bookings","Places")
    val travel = viewModel.getTravel(id).observeAsState().value?.travel
    val tickets = viewModel.tickets
    val bookings = viewModel.bookings
    val places = viewModel.places
    viewModel.setViewModelTravelId(id)

    Column(modifier = Modifier.fillMaxSize()) {
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
                    text = travel?.name.toString(),
                    color = MaterialTheme.colors.background,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )
                IconButton(
                    onClick = {
                        navController.navigate("travel_edit_screen/$id")
                    },
                    modifier = Modifier.padding(end = 15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit travel icon",
                        tint = MaterialTheme.colors.background
                    )
                }
            }
        }

        var newTicket: Ticket? = null

        Box(modifier = Modifier
            .fillMaxSize()
            //.padding(10.dp)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(MaterialTheme.colors.background),
                reverseLayout = false,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                categories.forEach { category ->
                    stickyHeader {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            elevation = 5.dp,
                            backgroundColor = MaterialTheme.colors.secondary
                        ) {
                            Text(
                                modifier = Modifier.padding(8.dp),
                                text = category,
                                color = MaterialTheme.colors.onSecondary,
                                fontWeight = FontWeight.Bold,
                                fontSize = MaterialTheme.typography.body1.fontSize
                            )
                            IconButton(
                                onClick = {
                                    when (category){
                                        "Tickets" -> navController.navigate("add_ticket_screen")
                                        "Bookings" -> navController.navigate("add_booking_screen")
                                        "Places" -> navController.navigate("add_place_screen")
                                    }
                                },
                                modifier = Modifier.padding(end = 15.dp)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Add item icon",
                                    tint = MaterialTheme.colors.onSecondary
                                )
                            }

                        }
                    }
                    when (category) {
                        "Tickets" -> {
                            tickets?.let {
                                items(it) { ticket ->
                                    TicketListItem(ticket = ticket, navController = navController)
                                }
                            }
                        }
                        "Bookings" -> {
                            bookings?.let {
                                items(it) { booking ->
                                    BookingListItem(booking = booking, navController = navController)
                                }
                            }
                        }
                        else -> {
                            places?.let {
                                items(it) { place ->
                                    PlaceListItem(place = place, navController = navController)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

//    Column(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center
//    ) {
//        Column(
//            modifier = Modifier.fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.Center
//        ) {
//            Text(
//                modifier = Modifier.padding(bottom = 25.dp),
//                text = "Travel details",
//                color = MaterialTheme.colors.primary,
//                fontWeight = FontWeight.Bold,
//                fontSize = MaterialTheme.typography.h4.fontSize
//            )
//            TravelDetailsItem(tag = "Title:", description = viewModel.getTravel(id).observeAsState().value?.travel?.name.toString())
//            TravelDetailsItem(tag = "Description:", description = viewModel.getTravel(id).observeAsState().value?.travel?.description.toString())
//
//            //EditTravelButton
//            Button(
//                onClick = {
//                    navController.navigate("travel_edit_screen/$id"){
//                        popUpTo(Screen.TravelList.route){
//                            inclusive = true
//                        }
//                    }
//                },
//                modifier = Modifier
//                    .padding(10.dp)
//                    .size(150.dp, 40.dp)
//            ) {
//                Text(
//                    text = "Edit",
//                    color = MaterialTheme.colors.secondary,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = MaterialTheme.typography.button.fontSize
//                )
//            }
//        }
//    }

}