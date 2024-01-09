package com.example.finalyearproject.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.finalyearproject.ui.screen.viewModel.UserAccountViewModel


@Composable
fun logInScreen(
    navController: NavController,
    viewModel: UserAccountViewModel,
    modifier: Modifier = Modifier
) {

    //val state by viewModel.userAccountUiState.collectAsState()

    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        logIn(
            navController = navController,
            viewModel = viewModel
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun logIn(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: UserAccountViewModel
) {
    var emailTextValue by remember { mutableStateOf("") }
    var passwordTextValue by remember { mutableStateOf("") }
    val userState by viewModel.userExists.collectAsState()
    val currentUser by viewModel.currentUser.collectAsState()
    val showErrorDialog = remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            label = { Text(text = "Email") },
            value = emailTextValue,
            onValueChange = {
                emailTextValue = it
            }
        )
        OutlinedTextField(
            label = { Text(text = "Password") },
            value = passwordTextValue,
            onValueChange = {
                passwordTextValue = it
            }
        )
        Row(
            modifier = Modifier
        ) {
            viewModel.authenticate(emailTextValue, passwordTextValue)
            Button(onClick = {
                if(userState == true) {
                    viewModel.updateCurrentUser(emailTextValue)
                    navController.navigate("Home")
                } else {
                    showErrorDialog.value = true
                }
            }) {
                Text(text = "LogIn")
            }
            Button(onClick = {
                navController.navigate("SignUp")
            }) {
                Text(text = "SignUp")
            }
        }
    }
    if (showErrorDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showErrorDialog.value = false // Dismiss the dialog
            },
            title = { Text(text = "Login Failed") },
            text = { Text(text = "Incorrect email or password.") },
            confirmButton = {
                Button(
                    onClick = {
                        showErrorDialog.value = false // Dismiss the dialog
                    }
                ) {
                    Text(text = "OK")
                }
            }
        )
    }
}

