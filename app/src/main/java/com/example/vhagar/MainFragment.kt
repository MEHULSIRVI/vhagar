package com.example.vhagar

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.vhagar.databinding.ActivityMainBinding
import com.example.vhagar.databinding.FragmentMainBinding
import com.mapbox.maps.MapView
import com.mapbox.maps.Style


class MainFragment : Fragment() {

    private lateinit var binding: FragmentMainBinding

    var mapView: MapView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        val view = binding.root

        mapView = binding.mapView
        mapView?.getMapboxMap()?.loadStyleUri(Style.MAPBOX_STREETS)


        return view
    }

}
