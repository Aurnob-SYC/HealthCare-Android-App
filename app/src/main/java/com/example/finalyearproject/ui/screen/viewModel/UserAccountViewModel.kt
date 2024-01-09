package com.example.finalyearproject.ui.screen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalyearproject.data.dao.UserAccountDao
import com.example.finalyearproject.data.entity.UserAccount
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch

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
            _userExists.value = checkUserAccount!=null
        }
    }

    fun deleteAll() {
        viewModelScope.launch(Dispatchers.IO) {
            userAccountDao.deleteAll()
        }
    }

    fun updateCurrentUser(email: String?) {
        _currentUser.value = email
    }

}

data class UserAccountUiState(
    val userAccountDetails: UserAccount = UserAccount(),
    val isAdmin: Boolean = false
)