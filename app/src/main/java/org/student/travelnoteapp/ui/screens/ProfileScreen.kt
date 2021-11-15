package org.student.travelnoteapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.student.travelnoteapp.R


@Composable
fun ProfileScreen (
    navController : NavController
) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        var fistNameText by rememberSaveable { mutableStateOf("") }
        var lastNameText by rememberSaveable { mutableStateOf("") }
        var emailText by rememberSaveable { mutableStateOf("") }
        var phoneText by rememberSaveable { mutableStateOf("") }
        var countryText by rememberSaveable { mutableStateOf("") }


        Text(
            modifier = Modifier.padding(bottom = 25.dp),
            text = "Profile",
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h4.fontSize
        )

        OutlinedTextField(
            value = fistNameText,
            onValueChange = {
                    newText -> fistNameText = newText
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

        OutlinedTextField(
            value = lastNameText,
            onValueChange = {
                    newText -> lastNameText = newText
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

        OutlinedTextField(
            value = emailText,
            onValueChange = {
                    newText -> emailText = newText
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

        OutlinedTextField(
            value = phoneText,
            onValueChange = {
                    newText -> phoneText = newText
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

        OutlinedTextField(
            value = countryText,
            onValueChange = {
                    newText -> countryText = newText
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

        Button(
            onClick = {

                navController.navigate(Screen.Login.rout){
                    popUpTo(Screen.Login.rout){
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

@Composable
@Preview(showBackground = true)
fun ProfileScreenPreview() {
    ProfileScreen(
        navController = rememberNavController()
    )
}