package org.student.travelnoteapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowRightAlt
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.student.travelnoteapp.data.room.model.Ticket

@Composable
fun TicketListItem(
    ticket: Ticket?,
    navController: NavController
) {

    val selectedIndex by remember{ mutableStateOf(-1) }
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.secondaryVariant)
            .fillMaxWidth()
            .height(53.dp)
            .selectable(
                selected = true,
                onClick = {
                    navController.navigate("ticket_details_screen/${ticket?.travelId}/${ticket?.id}")
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Column {
            Row {
                Text(
                    text = ticket?.destinationFrom.toString(),
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 10.dp)
                )
                Icon(
                    imageVector = Icons.Default.ArrowRightAlt,
                    contentDescription = "Destination Icon"
                )
                Text(
                    text = ticket?.destinationTo.toString(),
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
            }
        }
        Column {
            Row {
                Text(
                    text = ticket?.time.toString(),
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal
                )
                Text(
                    text = ticket?.date.toString().substring(0,5),
                    color = MaterialTheme.colors.primaryVariant,
                    fontSize = MaterialTheme.typography.body1.fontSize,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier.padding(start = 7.dp, end = 10.dp)
                )
            }
        }
    }

}