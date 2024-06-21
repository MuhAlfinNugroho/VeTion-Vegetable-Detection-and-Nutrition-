package com.vetion.capstoneproject.tips

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vetion.capstoneproject.response.Data
import com.vetion.capstoneproject.retrofit.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TipsViewModel : ViewModel() {
    private val _listTips = MutableLiveData<List<Data>>()
    val listTips: LiveData<List<Data>> = _listTips

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading


    init {
        getTips() //inisialisasi (init block), fungsi getTips() dipanggil untuk mengambil data tips secara awal.
    }

    fun getTips() {
        _isLoading.value = true
        val apiService = ApiConfig.getApiService()

        apiService.getAllTips().enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                _isLoading.value = false
                if (response.isSuccessful) {
                    _listTips.value = response.body()
                } else {
                    Log.e(TAG, "getAllTips failed: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                _isLoading.value = false
                Log.e(TAG, "getAllTips onFailure: ${t.message}")
            }
        })
    }

    fun searchTips(keyword: String) {
        val apiService = ApiConfig.getApiService()

        apiService.searchTips(keyword).enqueue(object : Callback<List<Data>> {
            override fun onResponse(call: Call<List<Data>>, response: Response<List<Data>>) {
                if (response.isSuccessful) {
                    _listTips.value = response.body()
                } else {
                    Log.e(TAG, "searchTips failed: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<List<Data>>, t: Throwable) {
                Log.e(TAG, "searchTips onFailure: ${t.message}")
            }
        })
    }

    companion object {
        private const val TAG = "TipsViewModel"
    }
}
