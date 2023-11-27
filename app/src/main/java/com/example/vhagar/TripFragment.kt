package com.example.vhagar

import android.graphics.Color.rgb
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mapbox.geojson.Point
import com.mapbox.maps.MapView
import com.mapbox.maps.MapboxMap
import com.mapbox.maps.Style
import com.mapbox.maps.dsl.cameraOptions
import com.mapbox.maps.extension.style.atmosphere.generated.atmosphere
import com.mapbox.maps.extension.style.layers.properties.generated.ProjectionName
import com.mapbox.maps.extension.style.projection.generated.projection
import com.mapbox.maps.extension.style.sources.generated.rasterDemSource
import com.mapbox.maps.extension.style.style
import com.mapbox.maps.extension.style.terrain.generated.terrain
import com.mapbox.maps.plugin.animation.MapAnimationOptions.Companion.mapAnimationOptions
import com.mapbox.maps.plugin.animation.flyTo
import com.mapbox.maps.plugin.gestures.OnMapClickListener
import com.mapbox.maps.plugin.gestures.addOnMapClickListener

class TripFragment : Fragment(), OnMapClickListener {

    private lateinit var mapboxMap: MapboxMap

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mapView = MapView(requireContext())
        return mapView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mapboxMap = (view as MapView).getMapboxMap()
        mapboxMap.loadStyle(
            style(Style.SATELLITE_STREETS) {
                +projection(ProjectionName.GLOBE)
                +atmosphere {
                    color(rgb(220, 159, 159))
                    highColor(rgb(220, 159, 159))
                    horizonBlend(0.4)
                }
                +rasterDemSource("raster-dem") {
                    url("mapbox://mapbox.terrain-rgb")
                }
                +terrain("raster-dem") {
                    exaggeration(1.5)
                }
            }
        ) {
            Toast.makeText(
                requireContext(),
                getString(R.string.hello_blank_fragment),
                Toast.LENGTH_LONG
            ).show()
            mapboxMap.addOnMapClickListener(this@TripFragment)
        }
    }

    override fun onMapClick(point: Point): Boolean {
        mapboxMap.flyTo(
            cameraOptions {
                center(point)
                zoom(12.5)
                pitch(75.0)
                bearing(130.0)
            },
            mapAnimationOptions {
                duration(12_000)
            }
        )
        return true
    }
}
