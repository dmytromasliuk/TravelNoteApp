package org.student.travelnoteapp.presentation.travel

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
import org.student.travelnoteapp.data.room.model.Travel
import org.student.travelnoteapp.presentation.util.Screen

@Composable
fun TravelEditScreen(
    navController: NavController,
    viewModel: TravelEditViewModel = hiltViewModel(),
    id: Long
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
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
                    text = "Edit travel",
                    color = MaterialTheme.colors.background,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )
                IconButton(
                    onClick = {
                        viewModel.deleteTravel(id)
                        navController.navigate(Screen.TravelList.route)
                        {
                            popUpTo(Screen.TravelList.route){
                                inclusive = true
                            }
                        }
                    },
                    modifier = Modifier.padding(end = 15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Delete,
                        contentDescription = "Delete travel icon",
                        tint = MaterialTheme.colors.background
                    )
                }
                IconButton(
                    onClick = {
                        val travel = Travel(
                            id,
                            0,
                            viewModel.travelNameText.value,
                            viewModel.descriptionText.value,
                            false
                        )
                        viewModel.updateTravel(travel = travel)
                        navController.navigate("travel_details_screen/$id"){
                            popUpTo(Screen.TravelList.route){
                                inclusive = true
                            }
                        }
                    },
                    modifier = Modifier.padding(end = 15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Done,
                        contentDescription = "Update travel icon",
                        tint = MaterialTheme.colors.background
                    )
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            //Travel name
            OutlinedTextField(
                value = viewModel.travelNameText.value,
                onValueChange = {
                    viewModel.setTravelName(it)
                },
                label = {
                    Text(text = "Travel name")
                },
                modifier = Modifier.padding(5.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            //Description
            OutlinedTextField(
                value = viewModel.descriptionText.value,
                onValueChange = {
                    viewModel.setDescription(it)
                },
                label = {
                    Text(text = "Description")
                },
                modifier = Modifier.padding(5.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

        }
    }
}