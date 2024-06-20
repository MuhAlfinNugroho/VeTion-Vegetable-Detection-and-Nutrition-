package com.vetion.capstoneproject.view.signup

import androidx.lifecycle.ViewModel
import com.vetion.capstoneproject.ModelUser
import com.vetion.capstoneproject.RepositoryUser

class SignUpViewModel(private val userRepository: RepositoryUser) : ViewModel() {

    fun registerUser(name: String, email: String, password: String): Boolean {
        // Here you can add any logic to validate and register the user
        // For simplicity, let's assume the registration is always successful
        val userModel = ModelUser(email = email, token = "dummyToken", isLogin = true)
        userRepository.saveSession(userModel) // Use userRepository instead of repository
        return true
    }
}