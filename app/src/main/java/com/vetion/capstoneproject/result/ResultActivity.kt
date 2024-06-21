package com.vetion.capstoneproject.result

import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.vetion.capstoneproject.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inisialisasi view binding
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ambil URI gambar dari intent
        val imageUriString = intent.getStringExtra("imageUri")
        if (imageUriString != null) {
            val imageUri = Uri.parse(imageUriString)
            // Tampilkan gambar menggunakan Glide
            Glide.with(this).load(imageUri).into(binding.imageBroccoli)
        } else {
            Log.e("ResultActivity", "No image URI provided")
        }
    }
}