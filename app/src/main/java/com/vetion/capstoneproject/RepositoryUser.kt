package com.vetion.capstoneproject

import androidx.lifecycle.liveData
import com.google.gson.Gson
import com.vetion.capstoneproject.retrofit.ApiService
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import com.vetion.capstoneproject.Result
import com.vetion.capstoneproject.response.LoginResponse
import com.vetion.capstoneproject.response.RegisterResponse

class RepositoryUser private constructor(
    private val apiService: ApiService,
    private val userPreference: PreferenceUser
) {

    suspend fun saveSession(user: ModelUser) {
        userPreference.saveSession(user)
    }

    fun getSession(): Flow<ModelUser> {
        return userPreference.getSession()
    }

    suspend fun logout() {
        userPreference.logout()
    }

    fun signup(name: String, email: String, password: String) = liveData {
        emit(Result.Loading)
        try {
            val successResponse = apiService.signup(name, email, password)
            emit(Result.Success(successResponse))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, RegisterResponse::class.java)
            emit(Result.Error(errorResponse.message))
        }
    }

    companion object {
        @Volatile
        private var instance: RepositoryUser? = null
        fun getInstance(
            apiService: ApiService,
            userPreference: PreferenceUser
        ): RepositoryUser =
            instance ?: synchronized(this) {
                instance ?: RepositoryUser(apiService, userPreference)
            }.also { instance = it }
    }

    fun login(email: String, password: String) = liveData {
        emit(Result.Loading)
        try {
            val successResponse = apiService.login(email, password)
            val userModel = ModelUser(
                email = email,
                token = successResponse.accessToken,
                isLogin = true
            )
            saveSession(userModel)
            emit(Result.Success(successResponse))
        } catch (e: HttpException) {
            val errorBody = e.response()?.errorBody()?.string()
            val errorResponse = Gson().fromJson(errorBody, LoginResponse::class.java)
            emit(Result.Error(errorResponse.message))
        }
    }
}