package com.example.finalyearproject.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finalyearproject.data.entity.UserAccount
import com.example.finalyearproject.ui.theme.FinalYearProjectTheme


@Composable
fun signUpScreen(
    navController: NavController,
    viewModel: UserAccountViewModel,
    modifier: Modifier = Modifier
) {

    val state by viewModel.userAccountUiState.collectAsState()

    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        signUp(
            userAccount = state.userAccountDetails,
            navController = navController,
            viewModel = viewModel
        )
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun signUp(
    userAccount: UserAccount,
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: UserAccountViewModel
) {

    userAccount.copy("","","","")
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        OutlinedTextField(
            label = { Text(text = "Email") },
            value = userAccount.email,
            onValueChange = {
                viewModel.updateUiState(userAccount.copy(email = it))
            }
        )
        OutlinedTextField(
            label = { Text(text = "Password") },
            value = userAccount.password,
            onValueChange = {
                viewModel.updateUiState(userAccount.copy(password = it))
            }
        )
        OutlinedTextField(
            label = { Text(text = "Address") },
            value = userAccount.address,
            onValueChange = {
                viewModel.updateUiState(userAccount.copy(address = it))
            }
        )
        OutlinedTextField(
            label = { Text(text = "Contact") },
            value = userAccount.contact,
            onValueChange = {
                viewModel.updateUiState(userAccount.copy(contact = it))
            }
        )
        Row(
            modifier = Modifier
        ) {
            Button(onClick = {
                viewModel.saveUserAccount(userAccount)
                navController.navigate("LogIn")
            }) {
                Text(text = "Submit")
            }
            Button(onClick = {
                navController.navigate("LogIn")
            }) {
                Text(text = "Cancel")
            }
        }
    }
}


/*

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun previewSignUp() {
    FinalYearProjectTheme {
        signUp(navController = rememberNavController())
    }
}
*/
