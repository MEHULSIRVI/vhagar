package com.example.vhagar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.vhagar.R
import com.mapbox.maps.MapView
import com.mapbox.maps.Style
import com.mapbox.maps.plugin.Plugin

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        showFragment(MainFragment())
    }
    fun showFragment(fragment: Fragment) {
        val fram = supportFragmentManager.beginTransaction()

        fram.replace(R.id.main, fragment)
        fram.commit()
    }

}