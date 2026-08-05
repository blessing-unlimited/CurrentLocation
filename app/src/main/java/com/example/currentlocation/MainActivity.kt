package com.example.currentlocation

import android.Manifest
import android.content.pm.PackageManager
import android.graphics.Point
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
// com.google.android.gms.maps.MapView
import com.mapbox.maps.CameraOptions
import com.mapbox.maps.MapView
import com.mapbox.maps.MapInitOptions
import com.mapbox.maps.Style

class MainActivity : AppCompatActivity() {

    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var mapView: MapView
    private var locationLauncher = registerForActivityResult(ActivityResultContracts.
    RequestMultiplePermissions())
    {
        permissions ->

        if(permissions[Manifest.permission.ACCESS_COARSE_LOCATION] == true ||
            permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true)
        {
            getLocation()
        }
    }

    private fun getLocation() {
       if(ActivityCompat.checkSelfPermission(this,
               Manifest.permission.ACCESS_FINE_LOCATION)
           != PackageManager.PERMISSION_GRANTED
           && ActivityCompat.checkSelfPermission(this,
               Manifest.permission.ACCESS_COARSE_LOCATION)
           != PackageManager.PERMISSION_GRANTED
           )
               {return}

                fusedLocationClient.lastLocation.addOnSuccessListener {
                    location -> location?.let{
                    val userLocation = com.mapbox.geojson.Point.fromLngLat(location.longitude,
                        location.latitude)

                    mapView.mapboxMap.setCamera(
                        CameraOptions.Builder()
                        .center(userLocation).zoom(15.0).build())


                }
            }

    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        fusedLocationClient= LocationServices.getFusedLocationProviderClient(this)

        mapView= MapView(this, MapInitOptions(this, styleUri = Style.MAPBOX_STREETS))

        requestLocationPermissions()

        setContentView(mapView)


    }

    private fun requestLocationPermissions() {
        if(ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION)
            != PackageManager.PERMISSION_GRANTED
        )
        {
            locationLauncher.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                )
            )
        }
        else
        {
            getLocation()
        }
    }
}