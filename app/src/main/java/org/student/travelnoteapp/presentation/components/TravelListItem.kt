package org.student.travelnoteapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.student.travelnoteapp.data.room.model.relations.TravelWithAllInfo
import org.student.travelnoteapp.presentation.travel.TravelListViewModel

@Composable
fun TravelListItem(
    travel: TravelWithAllInfo,
    viewModel: TravelListViewModel = hiltViewModel(),
    navController : NavController
) {
    val selectedIndex by remember{ mutableStateOf(-1)}
    var isChecked by remember { mutableStateOf(false) }
    var starColor =
        if (travel.travel.isCurrent) MaterialTheme.colors.primary
        else MaterialTheme.colors.background


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
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text(
                text = travel.travel.name,
                color = MaterialTheme.colors.primary,
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Bold
            )
        }
        Column {
            Row{
                Text(
                    text = travel.travel.description,
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
                IconButton(
                    onClick = {

                    }
                ) {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Set current travel icon",
                        tint = starColor
                    )
                }
            }
        }
    }
}