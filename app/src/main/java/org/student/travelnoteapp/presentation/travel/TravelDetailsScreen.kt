package org.student.travelnoteapp.presentation.travel

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import org.student.travelnoteapp.presentation.components.TravelDetailsItem
import org.student.travelnoteapp.presentation.util.Screen

@Composable
fun TravelDetailsScreen(
    navController: NavController,
    viewModel: TravelDetailsViewModel = hiltViewModel(),
    id: Int
) {

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
                text = "Travel details",
                color = MaterialTheme.colors.primary,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.h4.fontSize
            )
            TravelDetailsItem(tag = "Title:", description = viewModel.getTravelName(id).value)
            TravelDetailsItem(tag = "Description:", description = viewModel.getTravelDescription(id).value)

            //EditTravelButton
            Button(
                onClick = {
                    navController.navigate("travel_edit_screen/$id"){
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
                    text = "Edit",
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
//fun TravelDetailsScreenPreview() {
//    TravelDetailsScreen(
//        navController = rememberNavController()
//    )
//}