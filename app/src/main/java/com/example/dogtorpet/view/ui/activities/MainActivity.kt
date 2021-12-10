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
import android.graphics.drawable.GradientDrawable
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.gms.maps.GoogleMap


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var map:GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        createFragment()

        fun createFragment() {
            val mapFragment: supportMapFragment =
                supportFragmentManager.findFragmentById(R.id.fragmentMap) as supportMapFragment
            mapFragment.getMapAsync(this)

        }

        fun latlng(d: Double, d1: Double): Any {

        }
    

        fun createMarker() {
            val coordinates = latlng(4.631650, -74.092584)
            TODO("Not yet implemented")
        }

        fun onMapReady(googleMaps: GoogleMap){
            val googleMap = null
            googleMap.also { map = it }
        createMarker()

    }
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

    private fun createFragment() {
        TODO("Not yet implemented")
    }
}

private fun Fragment?.getMapAsync(mainActivity: MainActivity) {

}
