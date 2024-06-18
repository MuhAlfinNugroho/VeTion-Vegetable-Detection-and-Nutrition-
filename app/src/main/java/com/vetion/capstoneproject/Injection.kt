package com.vetion.capstoneproject

import android.content.Context
import com.vetion.capstoneproject.retrofit.ApiConfig

object Injection {
    fun provideRepository(context: Context): RepositoryUser {
        val pref = PreferenceUser.getInstance(context.dataStore)
        val apiService = ApiConfig.getApiService()
        return RepositoryUser.getInstance(apiService, pref)
    }
}