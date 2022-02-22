package org.student.travelnoteapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.student.travelnoteapp.data.room.model.Place
import org.student.travelnoteapp.presentation.place.PlaceEditViewModel

@Composable
fun PlaceListItem(
    place: Place?,
    navController: NavController,
    viewModel: PlaceEditViewModel = hiltViewModel()
) {

    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.secondaryVariant)
            .fillMaxWidth()
            .height(53.dp)
            .selectable(
                selected = true,
                onClick = {
                    navController.navigate("place_details_screen/${place?.travelId}/${place?.id}")
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Row {
                Icon(
                    imageVector = Icons.Default.ArrowRight,
                    contentDescription = "Place Icon",
                    modifier = Modifier.padding(start = 5.dp)
                )
                Text(
                    text = place?.time.toString(),
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = place?.date.toString().substring(0,5),
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 7.dp)
                )
            }
        }
        Column {
            Text(
                text = place?.title.toString(),
                color = MaterialTheme.colors.primaryVariant,
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Normal,
                modifier = Modifier.padding(end = 10.dp)
            )
        }
    }

}