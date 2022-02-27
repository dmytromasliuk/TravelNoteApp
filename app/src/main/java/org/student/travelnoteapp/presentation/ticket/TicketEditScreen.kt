package org.student.travelnoteapp.presentation.ticket

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.student.travelnoteapp.data.room.model.Ticket

@Composable
fun TicketEditScreen(
    navController: NavController,
    viewModel: TicketEditViewModel = hiltViewModel(),
    travelId: Long,
    ticketId: Long
) {

    val context = LocalContext.current

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
                Column {
                    Text(
                        text = "Edit ticket",
                        color = MaterialTheme.colors.background,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 15.dp)
                    )
                }
                Column {
                    Row {
                        IconButton(
                            onClick = {
                                viewModel.deleteTicket(ticketId)
                                navController.navigate("travel_details_screen/$travelId")
                            },
                            modifier = Modifier.padding(end = 15.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete ticket icon",
                                tint = MaterialTheme.colors.background
                            )
                        }

                        IconButton(
                            onClick = {
                                val ticket = Ticket(
                                    ticketId,
                                    travelId,
                                    viewModel.ticketNumber.value,
                                    viewModel.destinationFrom.value,
                                    viewModel.destinationTo.value,
                                    viewModel.selectedVehicle.value,
                                    viewModel.price.value,
                                    viewModel.date.value,
                                    viewModel.time.value
                                )
                                viewModel.updateTicket(ticket)
                                navController.navigate("travel_details_screen/$travelId")
                            },
                            modifier = Modifier.padding(end = 15.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Done,
                                contentDescription = "Update ticket icon",
                                tint = MaterialTheme.colors.background
                            )
                        }
                    }
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            //Ticket number
            OutlinedTextField(
                value = viewModel.ticketNumber.value,
                onValueChange = {
                    viewModel.setTicketNumber(it)
                },
                label = {
                    Text(text = "Ticket number")
                },
                modifier = Modifier.padding(5.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            //Destination From
            OutlinedTextField(
                value = viewModel.destinationFrom.value,
                onValueChange = {
                    viewModel.setDestinationFrom(it)
                },
                label = {
                    Text(text = "Destination from")
                },
                modifier = Modifier.padding(5.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            //Destination To
            OutlinedTextField(
                value = viewModel.destinationTo.value,
                onValueChange = {
                    viewModel.setDestinationTo(it)
                },
                label = {
                    Text(text = "Destination to")
                },
                modifier = Modifier.padding(5.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            //Vehicle
            var expanded by remember { mutableStateOf(false) }
            val vehicleType = listOf("Bus","Train","Plane")
            var textFieldSize by remember { mutableStateOf(Size.Zero)}

            val icon = if (expanded)
                Icons.Filled.ArrowDropUp
            else
                Icons.Filled.ArrowDropDown

            OutlinedTextField(
                value = viewModel.selectedVehicle.value,
                onValueChange = {
                    viewModel.setSelectedVehicle(it)
                },
                label = {
                    Text(text = "Vehicle")
                },
                trailingIcon = {
                    Icon(
                        imageVector = icon,
                        contentDescription = "Vehicle DropDown Icon",
                        modifier = Modifier.clickable { expanded = !expanded }
                    )
                },
                modifier = Modifier
                    .padding(5.dp)
                    .onGloballyPositioned { coordinates ->
                        textFieldSize = coordinates.size.toSize()
                    },
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.width(with(LocalDensity.current){ textFieldSize.width.toDp() })
            ) {
                vehicleType.forEach { vehicle ->
                    DropdownMenuItem(onClick = {
                        expanded = false
                        viewModel.setSelectedVehicle(vehicle)
                    }) {
                        Text(text = vehicle)
                    }
                }
            }

            //DateTextField
            OutlinedTextField(
                value = viewModel.date.value,
                onValueChange = {
                    viewModel.setDate(it)
                },
                label = {
                    Text(text = "Date")
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Today,
                        contentDescription = "Date icon",
                        modifier = Modifier.clickable { viewModel.selectDate(context) }
                    )
                },
                modifier = Modifier
                    .padding(5.dp)

            )

            //TimeTextField
            OutlinedTextField(
                value = viewModel.time.value,
                onValueChange = {
                    viewModel.setTime(it)
                },
                label = {
                    Text(text = "Time")
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.AccessTime,
                        contentDescription = "Time icon",
                        modifier = Modifier.clickable { viewModel.selectTime(context) }
                    )
                },
                modifier = Modifier
                    .padding(5.dp)

            )

            //Price
            OutlinedTextField(
                value = viewModel.price.value,
                onValueChange = {
                    viewModel.setPrice(it)
                },
                label = {
                    Text(text = "Price")
                },
                trailingIcon = {
                    Text(text = "zl")
                },
                modifier = Modifier.padding(5.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )
        }
    }
    
}