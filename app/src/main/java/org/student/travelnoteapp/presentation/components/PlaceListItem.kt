package org.student.travelnoteapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
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
            .background(MaterialTheme.colors.secondary)
            .fillMaxWidth()
            .padding(24.dp)
            .selectable(
                selected = true,
                onClick = {

                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = place?.title.toString(),
            color = MaterialTheme.colors.primaryVariant,
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = place?.description.toString(),
            color = MaterialTheme.colors.primaryVariant,
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Normal
        )
    }

}