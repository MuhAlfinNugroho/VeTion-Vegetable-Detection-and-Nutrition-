package com.vetion.capstoneproject

import android.net.Uri
import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PhotoResult(
    val title: String,
    val tanggal: String,
    val hasil: String,
    val saran: String,
    val imageUri: Uri // Uri dari gambar hasil
) : Parcelable
