package org.student.travelnoteapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.student.travelnoteapp.data.room.model.Travel
import org.student.travelnoteapp.data.room.model.relations.TravelWithAllInfo
import org.student.travelnoteapp.presentation.util.Screen

@Composable
fun TravelListItem(
    travel: TravelWithAllInfo,
    navController : NavController
) {
    val selectedIndex by remember{ mutableStateOf(-1)}
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.secondary)
            .fillMaxWidth()
            .padding(24.dp)
            .selectable(
                selected = true,
                onClick = {
                    navController.navigate("travel_details_screen/" + travel.travel.id)
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = travel.travel.name,
            color = MaterialTheme.colors.primary,
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = travel.travel.description,
            color = MaterialTheme.colors.primaryVariant,
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Normal
        )
    }
}