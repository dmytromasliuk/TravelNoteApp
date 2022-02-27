package org.student.travelnoteapp.presentation.profile

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.student.travelnoteapp.presentation.util.Screen

@Composable
fun ProfileUpdateScreen(
    navController: NavController,
    viewModel: ProfileViewModel = hiltViewModel()
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            modifier = Modifier.padding(bottom = 25.dp),
            text = "Profile",
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h4.fontSize
        )

        //FirstNameTextField
        OutlinedTextField(
            value = viewModel.firstNameText.value,
            onValueChange = {
                viewModel.setFirstNameText(it)
            },
            label = {
                Text(text = "First name")
            },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "First name icon")
                }
            },
            modifier = Modifier.padding(5.dp),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )

        //LastNameTextField
        OutlinedTextField(
            value = viewModel.lastNameText.value,
            onValueChange = {
                viewModel.setLastNameText(it)
            },
            label = {
                Text(text = "Last name")
            },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Person,
                        contentDescription = "Last name icon")
                }
            },
            modifier = Modifier.padding(5.dp),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )

        //EmailTextField
        OutlinedTextField(
            value = viewModel.emailText.value,
            onValueChange = {
                viewModel.setEmailText(it)
            },
            label = {
                Text(text = "Email")
            },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Email,
                        contentDescription = "Email icon")
                }
            },
            modifier = Modifier.padding(5.dp),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )

        //phoneTextField
        OutlinedTextField(
            value = viewModel.phoneText.value,
            onValueChange = {
                viewModel.setPhoneText(it)
            },
            label = {
                Text(text = "Phone")
            },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Phone,
                        contentDescription = "Phone icon")
                }
            },
            trailingIcon = {
                IconButton(onClick = {

                }) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Edit icon")
                }
            },
            modifier = Modifier.padding(5.dp),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )

        //CountryTextField
        OutlinedTextField(
            value = viewModel.countryText.value,
            onValueChange = {
                viewModel.setCountryText(it)
            },
            label = {
                Text(text = "Country")
            },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Place,
                        contentDescription = "Location icon")
                }
            },
            trailingIcon = {
                IconButton(onClick = {

                }) {
                    Icon(
                        imageVector = Icons.Filled.Edit,
                        contentDescription = "Edit icon")
                }
            },
            modifier = Modifier.padding(5.dp),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            )
        )
    }
}
