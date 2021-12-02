package com.example.dogtorpet.view.ui.activities

import android.graphics.Color
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.dogtorpet.R
import com.example.dogtorpet.databinding.ActivityMainBinding
import com.google.android.material.bottomappbar.BottomAppBar


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
        configNav()


    }

    fun configNav() {
        val navView: BottomNavigationView = binding.navView

        navView.background = null

        val botView: BottomAppBar = binding.bottomappbar
        botView.setBackgroundColor(Color.parseColor("#C5F9F9"))
        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        navView.setupWithNavController(navController)

    }
}