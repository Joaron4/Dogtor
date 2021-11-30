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
import com.example.dogtorpet.databinding.FragmentHomeBinding as homebinding
import com.google.android.material.bottomappbar.BottomAppBar
import android.graphics.drawable.GradientDrawable
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var homeBinding: homebinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)



        val navView: BottomNavigationView = binding.navView

        navView.background = null

        val botView: BottomAppBar = binding.bottomappbar
        botView.setBackgroundColor(Color.parseColor("#C5F9F9"))

        //Color.parseColor("#C5F9F9")


        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_settings, R.id.navigation_account
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)


    }
}