package org.student.travelnoteapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.student.travelnoteapp.data.room.model.relations.BookingAndAddress

@Composable
fun BookingListItem(
    booking: BookingAndAddress?,
    navController: NavController
) {

    val selectedIndex by remember{ mutableStateOf(-1) }
    val bookingAddressText = "${booking?.address?.street}, ${booking?.address?.building}-${booking?.address?.apartment}"
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.secondaryVariant)
            .fillMaxWidth()
            .height(53.dp)
            .selectable(
                selected = true,
                onClick = {
                    navController.navigate("booking_details_screen/${booking?.booking?.travelId}/${booking?.booking?.id}/${booking?.address?.id}")
                }
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(
            text = booking?.booking?.title.toString(),
            color = MaterialTheme.colors.primaryVariant,
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(start = 10.dp)
        )
        Text(
            text = bookingAddressText,
            color = MaterialTheme.colors.primaryVariant,
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Normal,
            modifier = Modifier.padding(end = 10.dp)
        )
    }

}