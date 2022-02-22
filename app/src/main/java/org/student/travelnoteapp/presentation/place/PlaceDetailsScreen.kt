package org.student.travelnoteapp.presentation.place

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun PlaceDetailsScreen(
    navController: NavController,
    viewModel: PlaceDetailsViewModel = hiltViewModel(),
    travelId: Long,
    placeId: Long
) {

    val place = viewModel.getPlace(placeId).observeAsState().value
    val innerRowSpacer = 10.dp

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
                    text = "Place details",
                    color = MaterialTheme.colors.background,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )
                IconButton(
                    onClick = {
                        navController.navigate("place_edit_screen/$travelId/$placeId")
                    },
                    modifier = Modifier.padding(end = 15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Edit place icon",
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
            Row (horizontalArrangement = Arrangement.spacedBy(innerRowSpacer)) {
                Text(
                    text = "Title:",
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = place?.title.toString(),
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
            }
            Row (horizontalArrangement = Arrangement.spacedBy(innerRowSpacer)){
                Text(
                    text = "Description:",
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = place?.description.toString(),
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
            }
            Row (horizontalArrangement = Arrangement.spacedBy(innerRowSpacer)){
                Text(
                    text = "Date:",
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = place?.date.toString(),
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
            }
            Row (horizontalArrangement = Arrangement.spacedBy(innerRowSpacer)){
                Text(
                    text = "Time:",
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = place?.time.toString(),
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
            }
        }

    }

}