package com.example.finalyearproject.ui.screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.finalyearproject.data.entity.OrderDetails
import com.example.finalyearproject.ui.screen.viewModel.UserAccountViewModel
import kotlinx.coroutines.launch

@Composable
fun OrderDetailsScreen(
    navController: NavController,
    viewModel: UserAccountViewModel,
    modifier: Modifier = Modifier
) {
    // Get the current user's email from the view model
    val currentUser by viewModel.currentUser.collectAsState()

    // Fetch order details for the current user
    LaunchedEffect(key1 = currentUser) {
        currentUser?.let { email ->
            viewModel.getOrderDetailsByEmail(email)
        }
    }

    // Observe the order details
    val orderDetails by viewModel.orderDetails.collectAsState()

    // Display the order details
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Order Details",
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        orderDetails?.let { details ->
            if (details.products.isNotEmpty() || details.appointment.isNotEmpty()) {
                LazyColumn {
                    // Display doctor appointments
                    items(details.appointment) { appointment ->
                        Text(
                            text = "Doctor: ${appointment.first}, Date: ${appointment.second}",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }
                    // Display products
                    items(details.products) { product ->
                        Text(
                            text = "${product.first}: ${product.second}",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                    }

                }
            } else {
                Text(
                    text = "No items in your order.",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
        } ?: run {
            Text(
                text = "Loading...",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(bottom = 4.dp)
            )
        }
    }
}
