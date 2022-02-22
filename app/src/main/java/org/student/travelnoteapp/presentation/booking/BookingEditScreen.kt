package org.student.travelnoteapp.presentation.booking

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.student.travelnoteapp.data.room.model.Address
import org.student.travelnoteapp.data.room.model.Booking

@Composable
fun BookingEditScreen(
    navController: NavController,
    viewModel: BookingEditViewModel = hiltViewModel(),
    travelId: Long,
    bookingId: Long,
    addressId: Long
) {

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
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
                        text = "Add new booking",
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
                                viewModel.deleteBooking(bookingId, addressId)
                                navController.navigate("travel_details_screen/$travelId")
                            },
                            modifier = Modifier.padding(end = 15.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete booking icon",
                                tint = MaterialTheme.colors.background
                            )
                        }
                        IconButton(
                            onClick = {
                                val booking = Booking(
                                    bookingId,
                                    travelId,
                                    addressId,
                                    viewModel.title.value,
                                    viewModel.email.value,
                                    viewModel.phone.value,
                                    viewModel.price.value
                                )
                                val address = Address(
                                    addressId,
                                    viewModel.apartment.value,
                                    viewModel.building.value,
                                    viewModel.street.value,
                                    viewModel.city.value,
                                    viewModel.country.value
                                )
                                viewModel.updateBooking(booking, address)
                                navController.navigate("travel_details_screen/$travelId")
                            },
                            modifier = Modifier.padding(end = 15.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Done,
                                contentDescription = "Add booking icon",
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

            //Title
            OutlinedTextField(
                value = viewModel.title.value,
                onValueChange = {
                    viewModel.setTitle(it)
                },
                label = {
                    Text(text = "Title")
                },
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                val customTextFieldWidth = 180.dp

                //Country
                OutlinedTextField(
                    value = viewModel.country.value,
                    onValueChange = {
                        viewModel.setCountry(it)
                    },
                    label = {
                        Text(text = "Country")
                    },
                    modifier = Modifier
                        .padding(5.dp)
                        .width(customTextFieldWidth),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    )
                )

                //City
                OutlinedTextField(
                    value = viewModel.city.value,
                    onValueChange = {
                        viewModel.setCity(it)
                    },
                    label = {
                        Text(text = "City")
                    },
                    modifier = Modifier
                        .padding(5.dp)
                        .width(customTextFieldWidth),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    )
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                val buildingAndApartmentTextFieldWidth = 85.dp

                //Street
                OutlinedTextField(
                    value = viewModel.street.value,
                    onValueChange = {
                        viewModel.setStreet(it)
                    },
                    label = {
                        Text(text = "Street")
                    },
                    modifier = Modifier
                        .padding(5.dp)
                        .width(180.dp),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    )
                )

                //Building
                OutlinedTextField(
                    value = viewModel.building.value,
                    onValueChange = {
                        viewModel.setBuilding(it)
                    },
                    label = {
                        Text(text = "bldg.")
                    },
                    modifier = Modifier
                        .padding(5.dp)
                        .width(buildingAndApartmentTextFieldWidth),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    )
                )

                //Apartment
                OutlinedTextField(
                    value = viewModel.apartment.value,
                    onValueChange = {
                        viewModel.setApartment(it)
                    },
                    label = {
                        Text(text = "apt.")
                    },
                    modifier = Modifier
                        .padding(5.dp)
                        .width(buildingAndApartmentTextFieldWidth),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Done
                    )
                )

            }

            //Email
            OutlinedTextField(
                value = viewModel.email.value,
                onValueChange = {
                    viewModel.setEmail(it)
                },
                label = {
                    Text(text = "Email")
                },
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            //Phone
            OutlinedTextField(
                value = viewModel.phone.value,
                onValueChange = {
                    viewModel.setPhone(it)
                },
                label = {
                    Text(text = "Phone")
                },
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
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
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )
        }
    }

}