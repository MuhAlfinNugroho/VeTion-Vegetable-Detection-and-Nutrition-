package com.vetion.capstoneproject.ui

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.vetion.capstoneproject.R
import com.vetion.capstoneproject.view.login.LoginActivity

class LogoutFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_logout, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Mendapatkan referensi ke Floating Action Button (FAB) dari layout
        val fabLogout: FloatingActionButton = view.findViewById(R.id.fab_logout)

        // Menambahkan OnClickListener ke FAB
        fabLogout.setOnClickListener {
            // Menambahkan logika logout di sini, misalnya:
            // 1. Mengakhiri sesi pengguna
            // 2. Pindah ke LoginActivity

            // Contoh logika:
            // Anda bisa menambahkan logika sesuai dengan cara Anda mengelola sesi.
            // Misalnya, jika Anda menggunakan Firebase Authentication:
            // FirebaseAuth.getInstance().signOut()

            // Setelah itu, pindah ke LoginActivity
            val intent = Intent(requireContext(), LoginActivity::class.java)
            // Membuat intent baru dengan flag untuk membersihkan semua tumpukan aktivitas sebelumnya
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            // Memulai LoginActivity
            startActivity(intent)
        }
    }
}
