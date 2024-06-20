package com.vetion.capstoneproject.view.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vetion.capstoneproject.ModelUser
import com.vetion.capstoneproject.RepositoryUser
import kotlinx.coroutines.launch

class LoginViewModel(private val userRepository: RepositoryUser) : ViewModel() {

    fun saveSession(user: ModelUser) {
        viewModelScope.launch {
            userRepository.saveSession(user)
        }
    }

    fun login(email: String, password: String): Boolean {
        // Here you can add any logic to validate and login the user
        // For simplicity, let's assume the login is always successful
        val userModel = ModelUser(email = email, token = "dummyToken", isLogin = true)
        saveSession(userModel)
        return true
    }
}
