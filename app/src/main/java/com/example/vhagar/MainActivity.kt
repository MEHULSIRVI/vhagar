package com.example.vhagar

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.vhagar.databinding.ActivityMainBinding

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
