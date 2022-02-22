package org.student.travelnoteapp.presentation.place

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Today
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.student.travelnoteapp.data.room.model.Place

@Composable
fun PlaceEditScreen(
    navController: NavController,
    viewModel: PlaceEditViewModel = hiltViewModel(),
    travelId: Long,
    placeId: Long
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
                        text = "Edit place",
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
                                viewModel.deletePlace(placeId)
                                navController.navigate("travel_details_screen/$travelId")
                            },
                            modifier = Modifier.padding(end = 15.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Delete,
                                contentDescription = "Delete place icon",
                                tint = MaterialTheme.colors.background
                            )
                        }
                        IconButton(
                            onClick = {
                                val place = Place(
                                    placeId,
                                    travelId,
                                    viewModel.title.value,
                                    viewModel.description.value,
                                    viewModel.date.value,
                                    viewModel.time.value
                                )
                                viewModel.updatePlace(place)
                                navController.navigate("travel_details_screen/$travelId")
                            },
                            modifier = Modifier.padding(end = 15.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Done,
                                contentDescription = "Update place icon",
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
            verticalArrangement = Arrangement.Top
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

            //Description
            OutlinedTextField(
                value = viewModel.description.value,
                onValueChange = {
                    viewModel.setDescription(it)
                },
                placeholder = {
                    Text(text = "...")
                },
                label = {
                    Text(text = "Description")
                },
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .height(150.dp),
                maxLines = 10,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                //DateTextField
                val customTextFieldWidth = 170.dp
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
                        .width(customTextFieldWidth)

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
                        .width(customTextFieldWidth)

                )
            }
        }
    }

}