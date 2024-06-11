import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.finalyearproject.data.entity.Appointment
import com.example.finalyearproject.data.entity.Doctor
import com.example.finalyearproject.ui.screen.viewModel.UserAccountViewModel
import kotlinx.coroutines.launch
import java.util.*

@Composable
fun DoctorScreen(
    navController: NavController,
    viewModel: UserAccountViewModel,
    modifier: Modifier = Modifier
) {
    // For demonstration, we'll use a sample list of doctors and appointments
    val doctors = remember {
        mutableStateListOf(
            Doctor(name = "Dr. Smith", price = 100),
            Doctor(name = "Dr. Johnson", price = 120),
            Doctor(name = "Dr. Lee", price = 150)
        )
    }

    val appointments = remember {
        mutableStateListOf(
            Appointment(name = "Dr. Smith", date = Date(), slots = listOf(true, false, true, false)),
            Appointment(name = "Dr. Johnson", date = Date(), slots = listOf(false, true, false, true)),
            Appointment(name = "Dr. Lee", date = Date(), slots = listOf(true, true, true, false))
        )
    }

    val cart = remember { mutableStateListOf<Pair<Doctor, Appointment>>() }
    val coroutineScope = rememberCoroutineScope()

    Column(modifier = modifier.padding(16.dp)) {
        LazyColumn {
            items(doctors) { doctor ->
                val doctorAppointments = appointments.filter { it.name == doctor.name }
                DoctorItem(
                    doctor = doctor,
                    appointments = doctorAppointments,
                    onAddToCart = { selectedDoctor, selectedAppointment ->
                        coroutineScope.launch {
                            cart.add(Pair(selectedDoctor, selectedAppointment))
                            viewModel.addDoctorAppointmentToOrder(email = viewModel.currentUser.value ?: "", selectedDoctor.name, selectedAppointment.date ?: Date())
                        }
                    }
                )
            }
        }
    }
}

@Composable
fun DoctorItem(
    doctor: Doctor,
    appointments: List<Appointment>,
    onAddToCart: (Doctor, Appointment) -> Unit
) {
    Column(modifier = Modifier.padding(8.dp)) {
        Text(text = doctor.name, style = MaterialTheme.typography.bodyLarge)
        Text(text = "Consultation Fee: $${doctor.price}", style = MaterialTheme.typography.bodyLarge)
        appointments.forEach { appointment ->
            AppointmentItem(
                doctor = doctor,
                appointment = appointment,
                onAddToCart = onAddToCart
            )
        }
    }
}

@Composable
fun AppointmentItem(
    doctor: Doctor,
    appointment: Appointment,
    onAddToCart: (Doctor, Appointment) -> Unit
) {
    val configuration = LocalConfiguration.current
    val isPortrait = configuration.orientation == android.content.res.Configuration.ORIENTATION_PORTRAIT

    Column(
        modifier = Modifier
            .padding(4.dp)
            .clickable { onAddToCart(doctor, appointment) }
    ) {
        Column {
            Text(
                text = "Date: ${appointment.date}",
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.padding(end = 8.dp)
            )
            if (isPortrait) {
                Column {
                    Text(
                        text = "Slots:",
                        style = MaterialTheme.typography.bodyLarge
                    )
                    appointment.slots?.forEachIndexed { index, isAvailable ->
                        Text(
                            text = "Slot $index: ${if (isAvailable) "Available" else "Booked"}",
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
            } else {
                Text(
                    text = "Slots: ${appointment.slots?.joinToString { if (it) "Available" else "Booked" }}",
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    }
}
