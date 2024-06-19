package com.vetion.capstoneproject.view.signup

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.vetion.capstoneproject.MainActivity
import com.vetion.capstoneproject.ModelUser
import com.vetion.capstoneproject.R
import com.vetion.capstoneproject.Result
import com.vetion.capstoneproject.ViewModelFactory
import com.vetion.capstoneproject.databinding.ActivitySignUpBinding
import com.vetion.capstoneproject.response.RegisterResponse

class SignUpActivity : AppCompatActivity() {

    private val viewModel: SignUpViewModel by viewModels {
        ViewModelFactory.getInstance(this)
    }

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupView()
        setupAction()
    }

    private fun setupView() {
        @Suppress("DEPRECATION")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }
        supportActionBar?.hide()
    }

    private fun setupAction() {
        binding.registerButton.setOnClickListener {
            val name = binding.nameEditText.text.toString()
            val email = binding.emailEditText.text.toString()
            val password = binding.passEditText.text.toString()

            // Perform signup action
            viewModel.signup(name, email, password).observe(this) { result ->
                when (result) {
                    is Result.Loading -> {
                        showLoading(true)
                    }
                    is Result.Success -> {
                        showLoading(false)
                        val registerResponse = result.data // Access the data properly

                        // Check if token is not null, otherwise handle the case accordingly
                        registerResponse?.let { response ->
                            showToast(response.message ?: "Success") // Show appropriate message
                            val token = response.token

                            if (!token.isNullOrEmpty()) {
                                val userModel = ModelUser(
                                    email = email,
                                    token = token,
                                    isLogin = true
                                )

                                AlertDialog.Builder(this).apply {
                                    setTitle(getString(R.string.success))
                                    setMessage(getString(R.string.success_login))
                                    setPositiveButton(getString(R.string.continue_main)) { _, _ ->
                                        val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                                        intent.flags =
                                            Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
                                        startActivity(intent)
                                        finish()
                                    }
                                    create()
                                    show()
                                }
                            } else {
                                showToast("Token is empty")
                            }
                        }
                    }
                    is Result.Error -> {
                        showLoading(false)
                        showToast(result.error)
                    }
                }
            }
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
