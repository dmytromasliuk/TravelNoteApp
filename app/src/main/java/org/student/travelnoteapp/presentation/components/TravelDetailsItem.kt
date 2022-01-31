package org.student.travelnoteapp.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun TravelDetailsItem(
    tag: String,
    description: String
) {

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(bottom = 25.dp),
            text = tag,
            color = MaterialTheme.colors.onSecondary,
            fontWeight = FontWeight.Light,
            fontSize = MaterialTheme.typography.body1.fontSize
        )
        Text(
            modifier = Modifier.padding(bottom = 25.dp),
            text = description,
            color = MaterialTheme.colors.primaryVariant,
            fontWeight = FontWeight.Normal,
            fontSize = MaterialTheme.typography.body1.fontSize
        )
    }

}