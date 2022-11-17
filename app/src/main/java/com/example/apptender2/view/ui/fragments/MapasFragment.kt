package com.example.apptender2.view.ui.fragments

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.apptender2.R
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth


class mapasFragment() : Fragment(), OnMapReadyCallback {
    private lateinit var googleMap: GoogleMap
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_mapas, container, false)
        val mapasFragment =
            this.childFragmentManager.findFragmentById(R.id.map_view) as SupportMapFragment
        mapasFragment.getMapAsync(this)
        return view

    }


    override fun onMapReady(map: GoogleMap) {
        val colombia = LatLng(4.570868, 74.297333)
        map?.let {
            this.googleMap = it
            map.addMarker(MarkerOptions().position(colombia))
        }
        enableLocation()
    }

    private fun isLocationPermissionGrated() = ContextCompat.checkSelfPermission(
        this.requireContext(),
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    @SuppressLint("MissingPermission")
    private fun enableLocation() {
        if (!::googleMap.isInitialized) return
        if (isLocationPermissionGrated()) {
            googleMap.isMyLocationEnabled = true
        } else {
            requestLocationPermission()
        }
    }

    companion object {

        const val REQUEST_CODE_LOCATION = 0
    }

    private fun requestLocationPermission() {
        if (ActivityCompat.shouldShowRequestPermissionRationale(
                this.requireActivity(), Manifest.permission.ACCESS_FINE_LOCATION
            )
        ) {
            Toast.makeText(context, "requiere activar permisos en ajustes", Toast.LENGTH_SHORT)
                .show()

        } else {
            ActivityCompat.requestPermissions(
                this.requireActivity(), arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                REQUEST_CODE_LOCATION
            )
        }
    }

    @SuppressLint("MissingPermission")
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permission: Array<out String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            REQUEST_CODE_LOCATION ->
                if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    googleMap.isMyLocationEnabled = true
                } else {
                    Toast.makeText(
                        context,
                        "Para activar la localizacion ve ajustes y acepta los permisos",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            else -> {}
        }
    }
        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            val btm = view.findViewById<BottomNavigationView>(R.id.buttonnavigation)
            btm.setOnNavigationItemReselectedListener {
                when (it.itemId) {
                    R.id.Home -> findNavController().navigate(R.id.action_mapasFragment_to_home2Fragment)
                    R.id.Perf -> findNavController().navigate(R.id.action_mapasFragment_to_misdatosFragment)
                    R.id.Map -> findNavController().navigate(R.id.action_mapasFragment_self)
                    R.id.homeFragment -> findNavController().navigate(R.id.action_mapasFragment_to_homeFragment)
                    R.id.cerrar -> {
                        firebaseAuth.signOut()
                        findNavController().navigate(R.id.action_homeFragment_to_loginActivity)
                        true
                    }
                }
            }
        }
    }






