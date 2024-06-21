package com.vetion.capstoneproject.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _title = MutableLiveData<String>().apply {
        value = "Brocoli Hijau (Lorem Ipsum Dolor Sit Amet)"
    }
    val title: LiveData<String> = _title

    private val _tanggalPemeriksaan = MutableLiveData<String>().apply {
        value = "DD/MM/YYYY"
    }
    val tanggalPemeriksaan: LiveData<String> = _tanggalPemeriksaan

    private val _hasilPemeriksaan = MutableLiveData<String>().apply {
        value = "Bagus"
    }
    val hasilPemeriksaan: LiveData<String> = _hasilPemeriksaan

    private val _saranDetail = MutableLiveData<String>().apply {
        value = "Apabila Sayuran Memiliki Bau Yang Tidak Sedap Sebaiknya Hindari Untuk Membeli"
    }
    val saranDetail: LiveData<String> = _saranDetail
}
