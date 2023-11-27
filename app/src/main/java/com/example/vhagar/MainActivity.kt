package com.example.vhagar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.vhagar.R
import com.example.vhagar.databinding.ActivityMainBinding
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.Plugin

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        replaceFragment(MainFragment())
        val bottomNavigationView = binding.bottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.mapFragment -> {
                    // Handle map fragment navigation
                    replaceFragment(MainFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.weatherFragment -> {
                    // Handle weather fragment navigation
                    replaceFragment(WeatherFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.tripFragment -> {
                    // Handle trip fragment navigation
                    replaceFragment(TripFragment())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.profileFragment -> {
                    // Handle profile fragment navigation
                    replaceFragment(ProfileFragment())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

    }
    fun replaceFragment(fragment: Fragment) {
        val fram = supportFragmentManager.beginTransaction()

        fram.replace(R.id.main, fragment)
        fram.commit()
    }


}