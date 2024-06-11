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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finalyearproject.data.entity.LabTest
import com.example.finalyearproject.ui.screen.viewModel.UserAccountViewModel
import kotlinx.coroutines.launch

@Composable
fun LabTestScreen(
    navController: NavController,
    viewModel: UserAccountViewModel,
    modifier: Modifier = Modifier
) {
    // For demonstration, we'll use a sample list of lab tests
    val labTests = remember {
        mutableStateListOf(
            LabTest(name = "Blood Test", price = 50),
            LabTest(name = "Urine Test", price = 30),
            LabTest(name = "MRI Scan", price = 300)
        )
    }

    val cart = remember { mutableStateListOf<LabTest>() }
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = modifier.padding(16.dp)) {
        LazyColumn {
            items(labTests) { labTest ->
                LabTestItem(
                    labTest = labTest,
                    onAddToCart = { selectedLabTest ->
                        coroutineScope.launch {
                            cart.add(selectedLabTest)
                            viewModel.addLabTestToOrder(email = viewModel.currentUser.value ?: "", selectedLabTest.name, selectedLabTest.price)
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun LabTestItem(labTest: LabTest, onAddToCart: (LabTest) -> Unit) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .clickable { onAddToCart(labTest) }
    ) {
        Text(text = labTest.name, style = MaterialTheme.typography.bodyLarge)
        Text(text = "Price: $${labTest.price}", style = MaterialTheme.typography.bodyLarge)
    }
}
