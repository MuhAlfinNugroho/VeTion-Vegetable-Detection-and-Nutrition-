package com.vetion.capstoneproject

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vetion.capstoneproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController
    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_button) as NavHostFragment
        navController = navHostFragment.navController

        bottomNavigationView = binding.navView
        NavigationUI.setupWithNavController(bottomNavigationView, navController)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    if (navController.currentDestination?.id != R.id.navigation_home) {
                        navController.navigate(R.id.navigation_home)
                    }
                    true
                }
                R.id.navigation_dashboard -> {
                    if (navController.currentDestination?.id != R.id.navigation_dashboard) {
                        navController.navigate(R.id.navigation_dashboard)
                    }
                    true
                }
                R.id.navigation_notifications, R.id.menu3 -> {
                    if (navController.currentDestination?.id != R.id.navigation_notifications) {
                        navController.navigate(R.id.navigation_notifications)
                    }
                    true
                }
                R.id.menu2 -> {
                    if (navController.currentDestination?.id != R.id.navigation_tips) {
                        navController.navigate(R.id.navigation_tips)
                    }
                    true
                }
                R.id.menu4 -> {
                    if (navController.currentDestination?.id != R.id.navigation_nearby) {
                        navController.navigate(R.id.navigation_nearby)
                    }
                    true
                }
                R.id.menu1 -> {
                    if (navController.currentDestination?.id != R.id.navigation_home) {
                        navController.navigate(R.id.navigation_home)
                    }
                    true
                }
                R.id.menu5 -> {
                    if (navController.currentDestination?.id != R.id.navigation_logout) {
                        navController.navigate(R.id.navigation_logout)
                    }
                    true
                }
                else -> false
            }
        }

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.navigation_notifications) {
                bottomNavigationView.visibility = View.GONE
            } else {
                bottomNavigationView.visibility = View.VISIBLE
            }
        }
    }

    override fun onBackPressed() {
        // Ketika fragment kamera aktif, kembali ke home
        if (navController.currentDestination?.id == R.id.navigation_notifications) {
            navController.navigate(R.id.navigation_home)
            // Set bottom navigation marker ke home
            bottomNavigationView.selectedItemId = R.id.navigation_home
        } else {
            super.onBackPressed()
        }
    }
}
