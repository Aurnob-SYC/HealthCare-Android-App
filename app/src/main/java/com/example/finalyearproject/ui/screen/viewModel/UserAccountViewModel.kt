package com.example.finalyearproject.ui.screen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalyearproject.data.dao.UserAccountDao
import com.example.finalyearproject.data.entity.HealthArticles
import com.example.finalyearproject.data.entity.OrderDetails
import com.example.finalyearproject.data.entity.UserAccount
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import java.util.*

class UserAccountViewModel (val userAccountDao: UserAccountDao): ViewModel() {

    private val _userAccountUiState = MutableStateFlow(UserAccountUiState())
    val userAccountUiState: StateFlow<UserAccountUiState> = _userAccountUiState.asStateFlow()

    private val _userExists = MutableStateFlow(false)
    val userExists: StateFlow<Boolean> = _userExists.asStateFlow()

    private val _currentUser = MutableStateFlow<String?>(null)
    val currentUser: StateFlow<String?> = _currentUser.asStateFlow()

    fun updateUiState(userAccount: UserAccount) {
        val x = userAccount.password == "admin607"
        val updatedState = UserAccountUiState(userAccount, x)
        _userAccountUiState.value = updatedState
    }

    fun saveUserAccount(userAccount: UserAccount) {
        viewModelScope.launch(Dispatchers.IO) {
            userAccountDao.insert(userAccount)
        }
    }

    fun authenticate(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val checkUserAccount = userAccountDao.authenticate(email, password).firstOrNull()
            _userExists.value = checkUserAccount != null
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            userAccountDao.deleteAll()
        }
    }

    fun updateCurrentUser(email: String?) {
        _currentUser.value = email
       // fetchOrderDetails(email)
    }
    /*private fun fetchOrderDetails(email: String?) {
        viewModelScope.launch(Dispatchers.IO) {
            email?.let {
                val orderDetails = userAccountDao.getOrderDetailsByEmail(it).firstOrNull()
                _orderDetails.value = orderDetails
            }
        }
    }*/
    /*fun saveOrderDetails(orderDetails: OrderDetails) {
        viewModelScope.launch(Dispatchers.IO) {
            userAccountDao.insertOrderDetails(orderDetails)
            fetchOrderDetails(orderDetails.email) // Refresh the order details
        }
    }*/

    // OTHERS !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

    //HEALTH ARTICLES
    private val _healthArticlesList = MutableStateFlow<List<HealthArticles>>(emptyList())
    val healthArticlesList: StateFlow<List<HealthArticles>> = _healthArticlesList.asStateFlow()
    fun getHealthArticles() {
        viewModelScope.launch(Dispatchers.IO) {
            /*val temp = userAccountDao.getAllHealthArticles()
            _healthArticlesList.value = temp*/
            userAccountDao.getAllHealthArticles().collect { articles ->
                _healthArticlesList.value = articles
            }
        }
    }

    fun saveHealthArticles(healthArticles: List<HealthArticles>) {
        viewModelScope.launch(Dispatchers.IO) {
            userAccountDao.insertAllHealthArticles(healthArticles)
        }
    }
    ///

    fun addLabTestToOrder(email: String, labTestName: String, labTestPrice: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val currentOrder = userAccountDao.getOrderDetailsByEmail(email).firstOrNull()
            val updatedProducts = currentOrder?.products?.toMutableList() ?: mutableListOf()
            updatedProducts.add(Pair(labTestName, labTestPrice))

            val newOrderDetails = OrderDetails(
                email = email,
                products = updatedProducts,
                appointment = currentOrder?.appointment ?: emptyList()
            )
            userAccountDao.insertOrderDetails(newOrderDetails)
        }
    }

    // Add Doctor Appointment to Order
    fun addDoctorAppointmentToOrder(email: String, doctorName: String, appointmentDate: Date) {
        viewModelScope.launch(Dispatchers.IO) {
            val currentOrder = userAccountDao.getOrderDetailsByEmail(email).firstOrNull()
            val updatedAppointments = currentOrder?.appointment?.toMutableList() ?: mutableListOf()
            updatedAppointments.add(Pair(doctorName, appointmentDate))

            val newOrderDetails = OrderDetails(
                email = email,
                products = currentOrder?.products ?: emptyList(),
                appointment = updatedAppointments
            )
            userAccountDao.insertOrderDetails(newOrderDetails)
        }
    }

    // MED
    fun addMedicineToOrder(email: String, medicineName: String, quantity: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val currentOrder = userAccountDao.getOrderDetailsByEmail(email).firstOrNull()
            val updatedProducts = currentOrder?.products?.toMutableList() ?: mutableListOf()
            val existingProduct = updatedProducts.find { it.first == medicineName }

            if (existingProduct != null) {
                updatedProducts[updatedProducts.indexOf(existingProduct)] =
                    existingProduct.copy(second = existingProduct.second + quantity)
            } else {
                updatedProducts.add(Pair(medicineName, quantity))
            }

            val newOrderDetails = OrderDetails(
                email = email,
                products = updatedProducts,
                appointment = currentOrder?.appointment ?: emptyList()
            )
            userAccountDao.insertOrderDetails(newOrderDetails)
        }
    }
    ///
    fun getOrderDetailsByEmail(email: String) {
        viewModelScope.launch(Dispatchers.IO) {
            userAccountDao.getOrderDetailsByEmail(email).collect { orderDetails ->
                _orderDetails.value = orderDetails
            }
        }
    }

    // Variable to hold order details
    private val _orderDetails = MutableStateFlow<OrderDetails?>(null)
    val orderDetails: StateFlow<OrderDetails?> = _orderDetails.asStateFlow()
}

data class UserAccountUiState(
    val userAccountDetails: UserAccount = UserAccount(),
    val isAdmin: Boolean = false
)