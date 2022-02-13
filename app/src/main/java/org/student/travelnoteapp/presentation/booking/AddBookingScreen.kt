package org.student.travelnoteapp.presentation.booking

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.student.travelnoteapp.presentation.util.Screen

@Composable
fun AddBookingScreen(
    navController: NavController,
    viewModel: AddBookingViewModel = hiltViewModel()
) {

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
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
                    text = "Add new ticket",
                    color = MaterialTheme.colors.background,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )
                IconButton(
                    onClick = {
                        //navController.navigate("travel_edit_screen/$id")
                    },
                    modifier = Modifier.padding(end = 15.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Done,
                        contentDescription = "Add booking icon",
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

            //Title
            OutlinedTextField(
                value = viewModel.title.value,
                onValueChange = {
                    viewModel.setTitle(it)
                },
                label = {
                    Text(text = "Title")
                },
                modifier = Modifier.padding(5.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            //Destination From
            OutlinedTextField(
                value = viewModel.email.value,
                onValueChange = {
                    viewModel.setEmail(it)
                },
                label = {
                    Text(text = "Email")
                },
                modifier = Modifier.padding(5.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            //Destination To
            OutlinedTextField(
                value = viewModel.phone.value,
                onValueChange = {
                    viewModel.setPhone(it)
                },
                label = {
                    Text(text = "phone")
                },
                modifier = Modifier.padding(5.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            //Price
            OutlinedTextField(
                value = viewModel.price.value,
                onValueChange = {
                    viewModel.setPrice(it)
                },
                label = {
                    Text(text = "Price")
                },
                trailingIcon = {
                    Text(text = "zl")
                },
                modifier = Modifier.padding(5.dp),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )
        }
    }
}