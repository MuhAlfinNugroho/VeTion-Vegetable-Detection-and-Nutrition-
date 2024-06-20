package com.vetion.capstoneproject

import android.content.Context
import android.content.SharedPreferences
import com.vetion.capstoneproject.retrofit.ApiService

class RepositoryUser private constructor(
    private val apiService: ApiService,
    private val context: Context
) {

    companion object {
        @Volatile
        private var instance: RepositoryUser? = null

        fun getInstance(apiService: ApiService, context: Context): RepositoryUser =
            instance ?: synchronized(this) {
                instance ?: RepositoryUser(apiService, context).also { instance = it }
            }
    }

    private val sharedPreferences: SharedPreferences by lazy {
        context.getSharedPreferences("user_session", Context.MODE_PRIVATE)
    }

    fun saveSession(user: ModelUser) {
        sharedPreferences.edit().apply {
            putString("email", user.email)
            putString("token", user.token)
            putBoolean("isLogin", user.isLogin)
            apply()
        }
    }

    fun getSession(): ModelUser? {
        val email = sharedPreferences.getString("email", null)
        val token = sharedPreferences.getString("token", null)
        val isLogin = sharedPreferences.getBoolean("isLogin", false)
        return if (email != null && token != null) {
            ModelUser(email, token, isLogin)
        } else {
            null
        }
    }

    fun clearSession() {
        sharedPreferences.edit().clear().apply()
    }
}