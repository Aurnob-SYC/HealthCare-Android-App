import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.finalyearproject.data.entity.Medicine
import com.example.finalyearproject.ui.screen.viewModel.UserAccountViewModel
import kotlinx.coroutines.launch

@Composable
fun MedicineScreen(
    navController: NavController,
    viewModel: UserAccountViewModel,
    modifier: Modifier = Modifier
) {
    // For demonstration, we'll use a sample list of medicines
    val medicines = remember {
        mutableStateListOf(
            Medicine(name = "Aspirin", price = 10),
            Medicine(name = "Ibuprofen", price = 15),
            Medicine(name = "Paracetamol", price = 12)
        )
    }

    val cart = remember { mutableStateListOf<Medicine>() }
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = modifier.padding(16.dp)) {
        LazyColumn {
            items(medicines) { medicine ->
                MedicineItem(
                    medicine = medicine,
                    onAddToCart = { selectedMedicine ->

                            viewModel.addMedicineToOrder(
                                email = viewModel.currentUser.value ?: "",
                                medicineName = selectedMedicine.name,
                                quantity = 1 // Assuming adding one quantity at a time
                            )


                    }
                )
            }
        }
    }
}

@Composable
fun MedicineItem(medicine: Medicine, onAddToCart: (Medicine) -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onAddToCart(medicine) }
    ) {
        Text(text = medicine.name, style = MaterialTheme.typography.bodyLarge)
        Text(text = "Price: $${medicine.price}", style = MaterialTheme.typography.bodyLarge)
    }
}
