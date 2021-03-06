package org.student.travelnoteapp.presentation.login

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.student.travelnoteapp.R
import org.student.travelnoteapp.data.room.model.Profile
import org.student.travelnoteapp.presentation.util.Screen
import timber.log.Timber

@Composable
fun LoginScreen(
    navController: NavController,
    viewModel: LoginViewModel = hiltViewModel()
) {

    val context = LocalContext.current
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){

        var passwordVisibility by rememberSaveable { mutableStateOf(false)}
        val visibilityIcon = if (passwordVisibility)
            painterResource(id = R.drawable.design_ic_visibility)
        else
            painterResource(id = R.drawable.design_ic_visibility_off)

        Text(
            modifier = Modifier.padding(bottom = 25.dp),
            text = "TravelNote",
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h3.fontSize
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

        //PasswordTextField
        OutlinedTextField(
            value = viewModel.passwordText.value,
            onValueChange = {
                    viewModel.setPasswordText(it)
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

        val profileResponse = viewModel.profileResponse.observeAsState().value
        var profile: Profile?
        //SignInButton
        Button(
            onClick = {
                viewModel.login()
                if (profileResponse == null){
                    Toast.makeText(context, "Login denied...", Toast.LENGTH_SHORT).show()
                } else {
                    coroutineScope.launch(Dispatchers.Main) {
                        val result = viewModel.isExistsByEmail(profileResponse.email)
                        if (result){
                            profile = viewModel.getProfileByEmail(email = profileResponse.email)//TODO: problem here =(
                            profile?.id?.let {
                                Profile(
                                    it,
                                    profileResponse.firstName,
                                    profileResponse.lastName,
                                    profileResponse.email,
                                    profileResponse.phone,
                                    profileResponse.country
                                )
                            }?.let {
                                navController.currentBackStackEntry?.arguments?.putParcelable("profile", profile)
                                viewModel.updateProfile(profile!!)
                            }
                        } else {
                            viewModel.createProfile()
                        }
                    }
                    navController.navigate(route = Screen.TravelList.route)
                    Toast.makeText(context, "Login success!", Toast.LENGTH_SHORT).show()
                }
            },
            modifier = Modifier
                .padding(10.dp)
                .size(150.dp, 40.dp)
        ) {
            Text(
                text = "Sign in",
                color = MaterialTheme.colors.background,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.button.fontSize
            )

        }

        //SignupTextField
        Text(
            modifier = Modifier.padding(top = 25.dp),
            text = "Don't have an account? Please, sign up!",
            color = MaterialTheme.colors.primary,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.body2.fontSize
        )

        //SignupButton
        Button(
            onClick = {
                navController.navigate(route = Screen.Registration.route)
            },
            modifier = Modifier
                .padding(10.dp)
                .size(100.dp, 40.dp)
        ) {
            Text(
                text = "Sign up",
                color = MaterialTheme.colors.background,
                fontWeight = FontWeight.Bold,
                fontSize = MaterialTheme.typography.button.fontSize
            )

        }
    }
}

@Composable
@Preview(showBackground = true)
fun LoginScreenPreview(){
    LoginScreen(
        navController = rememberNavController()
    )
}