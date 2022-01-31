package org.student.travelnoteapp.presentation.travel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.student.travelnoteapp.presentation.profile.ProfileViewModel
import org.student.travelnoteapp.presentation.util.Screen

@Composable
fun AddNewTravelScreen(
    navController : NavController,
    viewModel: AddNewTravelViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            modifier = Modifier.padding(bottom = 25.dp),
            text = "Add new travel",
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h4.fontSize
        )

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

        //Country
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


        //AddTravelButton
        Button(
            onClick = {
                viewModel.addNewTravel()
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
                text = "Add",
                color = MaterialTheme.colors.secondary,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.button.fontSize
            )

        }
    }
}