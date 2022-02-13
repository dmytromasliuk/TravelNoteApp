package org.student.travelnoteapp.presentation.place

import android.content.Context
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun AddPlaceScreen(
    navController: NavController,
    viewModel: AddPlaceViewModel = hiltViewModel()
) {

    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier
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
                    text = "Add new place",
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
                        contentDescription = "Add ticket icon",
                        tint = MaterialTheme.colors.background
                    )
                }
            }
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
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
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth(),
                singleLine = true,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            //Description
            OutlinedTextField(
                value = viewModel.description.value,
                onValueChange = {
                    viewModel.setDescription(it)
                },
                placeholder = {
                    Text(text = "...")
                },
                label = {
                    Text(text = "Description")
                },
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxWidth()
                    .height(150.dp),
                maxLines = 10,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ){
                //DateTextField
                val customTextFieldWidth = 170.dp
                OutlinedTextField(
                    value = viewModel.date.value,
                    onValueChange = {
                        viewModel.setDate(it)
                    },
                    label = {
                        Text(text = "Date")
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.Today,
                            contentDescription = "Date icon",
                            modifier = Modifier.clickable { viewModel.selectDate(context) }
                        )
                    },
                    modifier = Modifier
                        .padding(5.dp)
                        .width(customTextFieldWidth)

                )

                //TimeTextField
                OutlinedTextField(
                    value = viewModel.time.value,
                    onValueChange = {
                        viewModel.setTime(it)
                    },
                    label = {
                        Text(text = "Time")
                    },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Default.AccessTime,
                            contentDescription = "Time icon",
                            modifier = Modifier.clickable { viewModel.selectTime(context) }
                        )
                    },
                    modifier = Modifier
                        .padding(5.dp)
                        .width(customTextFieldWidth)

                )
            }
        }
    }

}