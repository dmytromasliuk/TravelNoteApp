package org.student.travelnoteapp.presentation.travel

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.student.travelnoteapp.data.room.model.Travel
import org.student.travelnoteapp.presentation.util.Screen
import timber.log.Timber

@Composable
fun TravelEditScreen(
    navController: NavController,
    viewModel: TravelEditViewModel = hiltViewModel(),
    id: Long
) {

    Timber.d("Id value in composable${id}")
    viewModel.setViewModelTravelId(id)

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                modifier = Modifier.padding(bottom = 25.dp),
                text = "Edit travel",
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h4.fontSize
            )

            //Travel name
            val travel = viewModel.getTravel(id).observeAsState().value?.travel
            val travelName by remember { mutableStateOf(travel?.name) }
            val travelDescription by remember { mutableStateOf(travel?.description) }
            val tn = viewModel.travelNameText.observeAsState(viewModel.getTravel(id).value?.travel?.name)
            Timber.d("Value in tn - $tn")
            OutlinedTextField(
                value = tn.value.toString(),
                onValueChange = { name ->
                    viewModel.setTravelName(name.trimStart { it == '0' })
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
            val td = viewModel.descriptionText.observeAsState(viewModel.getTravel(id).value?.travel?.description)
            OutlinedTextField(
                value = td.value.toString(),
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


            //UpdateTravelButton
            Button(
                onClick = {
                    val travel = Travel(
                        id,
                        0,
                        tn.value!!,
                        td.value!!
                    )
                    viewModel.updateTravel(travel = travel)
                    navController.navigate(Screen.TravelList.route){
                        popUpTo(Screen.TravelList.route){
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .padding(10.dp)
                    .size(150.dp, 40.dp)
            ) {
                Text(
                    text = "Update",
                    color = MaterialTheme.colors.secondary,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.button.fontSize
                )

            }

            //DeleteTravelButton
            Button(
                onClick = {
                    viewModel.deleteTravel(id)
                    navController.navigate(Screen.TravelList.route)
                    {
                        popUpTo(Screen.TravelList.route){
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .padding(10.dp)
                    .size(150.dp, 40.dp)
            ) {
                Text(
                    text = "Delete",
                    color = MaterialTheme.colors.secondary,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.button.fontSize
                )

            }
        }
    }
}

//@Composable
//@Preview(showBackground = true)
//fun TravelEditScreenPreview() {
//    TravelEditScreen(
//        navController = rememberNavController()
//    )
//}