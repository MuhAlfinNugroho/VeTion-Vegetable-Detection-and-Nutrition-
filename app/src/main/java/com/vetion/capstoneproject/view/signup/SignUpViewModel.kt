package com.vetion.capstoneproject.view.signup

import androidx.lifecycle.ViewModel
import com.vetion.capstoneproject.RepositoryUser

class SignUpViewModel (private val userRepository: RepositoryUser) : ViewModel() {

    fun signup(name: String, email: String, password: String) = userRepository.signup(name, email, password)
}