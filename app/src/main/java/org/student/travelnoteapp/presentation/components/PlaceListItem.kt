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
import androidx.navigation.NavController
import org.student.travelnoteapp.data.room.model.Place

@Composable
fun PlaceListItem(
    place: Place?,
    navController: NavController
) {

    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.secondaryVariant)
            .fillMaxWidth()
            .padding(15.dp)
            .selectable(
                selected = true,
                onClick = {

                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Row {
                Icon(
                    imageVector = Icons.Default.ArrowRight,
                    contentDescription = "Place Icon"
                )
                Text(
                    text = place?.time.toString(),
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
            }
        }
        Column {
            Text(
                text = place?.title.toString(),
                color = MaterialTheme.colors.primaryVariant,
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Normal
            )
        }
    }

}