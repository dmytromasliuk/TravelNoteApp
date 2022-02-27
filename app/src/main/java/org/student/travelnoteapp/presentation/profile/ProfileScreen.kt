package org.student.travelnoteapp.presentation.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import org.student.travelnoteapp.data.room.model.Profile
import org.student.travelnoteapp.presentation.util.Screen


@Composable
fun ProfileScreen (
    profile: Profile?,
    navController : NavController,
    viewModel: ProfileViewModel = hiltViewModel()
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

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
                    text = "Profile",
                    color = MaterialTheme.colors.background,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 15.dp)
                )
            }
        }



        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 75.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
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
                readOnly = true,
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
                readOnly = true,
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
                readOnly = true,
                modifier = Modifier.padding(5.dp),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Done
                )
            )

            var phoneUpdateState by remember{ mutableStateOf(false) }
            val inPhoneUpdateState = if (phoneUpdateState)
                Icons.Default.Done
            else Icons.Default.Edit

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
                        phoneUpdateState = !phoneUpdateState
                    }) {
                        Icon(
                            imageVector = inPhoneUpdateState,
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
            var countryUpdateState by remember{ mutableStateOf(false) }
            val inCountryUpdateState = if (countryUpdateState)
                Icons.Default.Done
            else Icons.Default.Edit

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
                        countryUpdateState = !countryUpdateState
                    }) {
                        Icon(
                            imageVector = inCountryUpdateState,
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

            //LogoutButton
            Button(
                onClick = {

                    navController.navigate(Screen.Login.route){
                        popUpTo(Screen.Login.route){
                            inclusive = true
                        }
                    }
                },
                modifier = Modifier
                    .padding(10.dp)
                    .size(150.dp, 40.dp)
            ) {
                Text(
                    text = "Logout",
                    color = MaterialTheme.colors.secondary,
                    fontWeight = FontWeight.Bold,
                    fontSize = MaterialTheme.typography.button.fontSize
                )

            }
        }
    }
}
