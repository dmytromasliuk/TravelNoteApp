package org.student.travelnoteapp.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import org.student.travelnoteapp.R

@Composable
fun RegistrationScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ){
        var fistNameText by rememberSaveable { mutableStateOf("") }
        var lastNameText by rememberSaveable { mutableStateOf("") }
        var emailText by rememberSaveable { mutableStateOf("") }
        var passwordText by rememberSaveable { mutableStateOf("") }
        var passwordVisibility by rememberSaveable { mutableStateOf(false)}
        val visibilityIcon = if (passwordVisibility)
            painterResource(id = R.drawable.design_ic_visibility)
        else
            painterResource(id = R.drawable.design_ic_visibility_off)

        Text(
            modifier = Modifier.padding(bottom = 25.dp),
            text = "Registration",
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
                        contentDescription = "Last name")
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
                                  contentDescription = "Email")
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
            value = passwordText,
            onValueChange = {
                    newText -> passwordText = newText
            },
            label = {
                Text(text = "Password")
            },
            leadingIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Lock,
                        contentDescription = "Password")
                }
            },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = visibilityIcon,
                        contentDescription = "Visibility icon")
                }
            },
            visualTransformation = if (passwordVisibility)
                VisualTransformation.None
            else
                PasswordVisualTransformation(),
            modifier = Modifier.padding(5.dp),
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password,
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
                text = "Sign up",
                color = MaterialTheme.colors.secondary,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.button.fontSize
            )

        }
    }
}

@Composable
@Preview(showBackground = true)
fun RegistrationScreenPreview(){
    RegistrationScreen(
        navController = rememberNavController()
    )
}