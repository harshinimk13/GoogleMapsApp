package com.example.googlemapsapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // Find the map fragment
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment

        // Load the map asynchronously
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {

        // Set the location to Bengaluru
        val bengaluru = LatLng(12.9716, 77.5946)

        // Add a marker at Bengaluru
        googleMap.addMarker(
            MarkerOptions()
                .position(bengaluru)
                .title("Bengaluru")
        )

        // Move the camera to Bengaluru
        googleMap.moveCamera(
            CameraUpdateFactory.newLatLngZoom(bengaluru, 12f)
        )
    }
}