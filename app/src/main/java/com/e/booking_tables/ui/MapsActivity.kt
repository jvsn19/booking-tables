package com.e.booking_tables.ui

import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.util.Log
import android.widget.Toast
import com.e.booking_tables.R
import com.e.booking_tables.firebase.FirebaseManager
import com.e.booking_tables.models.RestaurantModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.google.firebase.database.*
import java.lang.Exception

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    companion object  {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    private lateinit var mMap: GoogleMap
    private lateinit var fusedLocationClient: FusedLocationProviderClient
    private lateinit var userLocation: Location

    private lateinit var databaseReference: DatabaseReference
    private lateinit var firebaseManager : FirebaseManager
    private lateinit var restaurants : ArrayList<RestaurantModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_maps)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        databaseReference = FirebaseDatabase.getInstance().reference
        firebaseManager = FirebaseManager(this)

        restaurants = firebaseManager.loadDatabase()


    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        mMap.uiSettings.isZoomControlsEnabled = true
        mMap.setOnMarkerClickListener(this)

        setUpMap()

        for(restaurant in restaurants) {
            val restaurantLatLng = LatLng(restaurant.coords["lat"]!!.toDouble(), restaurant.coords["long"]!!.toDouble())
            placeMarker(restaurantLatLng, restaurants.indexOf(restaurant))
        }
    }

    override fun onMarkerClick(marker: Marker?): Boolean {
        launchRestaurantActivity(marker)
        return false
    }

    private fun launchRestaurantActivity(marker: Marker?) {
        val restaurantIdx = marker!!.tag.toString().toInt()
        val intent = Intent(this, RestaurantActivity::class.java)
        intent.putExtra("restaurantName", restaurants[restaurantIdx].name)
        intent.putExtra("restaurantAddress", restaurants[restaurantIdx].address)
        intent.putExtra("restaurantRating", restaurants[restaurantIdx].rating)
        intent.putExtra("restaurantMenu", restaurants[restaurantIdx].menu)
        print("${restaurants[restaurantIdx].menu}")

        var bundle = Bundle()
        bundle.putParcelableArrayList("restaurantMenu", restaurants[restaurantIdx].menu)
        intent.putExtras(bundle)

        startActivity(intent)
    }

    private fun setUpMap() {
        if(ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }
        mMap.isMyLocationEnabled = true

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            if(location != null) {
                userLocation = location
                val currentLatLng = LatLng(userLocation.latitude, userLocation.longitude)
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 17.0f))
            }
            else {
                displayToast("Zoom your map to see restaurants")
            }
        }
    }

    private fun displayToast(message: String) {
        val duration = Toast.LENGTH_LONG
        val toast = Toast.makeText(applicationContext, message, duration)

        toast.show()
    }

    private fun placeMarker(location: LatLng, tag: Int) {
        val markerOption = MarkerOptions().position(location)
        val addressText = getAddress(location)
        markerOption.title(addressText)
        val marker = mMap.addMarker(markerOption)
        marker.tag = tag
    }

    private fun getAddress(latLng: LatLng): String {
        val geocoder = Geocoder(this)
        val addresses: List<Address>?
        val address: Address?
        var addressText = ""

        try {
            addresses = geocoder.getFromLocation(latLng.latitude, latLng.longitude, 1)
            if(addresses != null && addresses.isNotEmpty()) {
                address = addresses[0]
                for(i in 0 until address.maxAddressLineIndex + 1) {
                    addressText += if (i == 0) address.getAddressLine(i) else "\n" + address.getAddressLine(i)
                }
            }
        } catch(e: Exception) {
            Log.e("MapsActivity", e.localizedMessage)
        }

        return addressText
    }
}
