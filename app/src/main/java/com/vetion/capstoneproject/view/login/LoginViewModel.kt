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

    fun login(email: String, password: String) = userRepository.login(email, password)
}
