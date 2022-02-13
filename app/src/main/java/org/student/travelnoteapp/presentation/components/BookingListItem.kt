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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import org.student.travelnoteapp.data.room.model.Booking
import org.student.travelnoteapp.data.room.model.relations.BookingAndAddress

@Composable
fun BookingListItem(
    booking: BookingAndAddress?,
    navController: NavController
) {

    val selectedIndex by remember{ mutableStateOf(-1) }
    val bookingAddressText = "${booking?.address?.city}: ${booking?.address?.street}, ${booking?.address?.building}-${booking?.address?.apartment}"
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
            text = booking?.booking?.title.toString(),
            color = MaterialTheme.colors.primaryVariant,
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = bookingAddressText,
            color = MaterialTheme.colors.primaryVariant,
            fontSize = MaterialTheme.typography.body1.fontSize,
            fontWeight = FontWeight.Normal
        )
    }

}