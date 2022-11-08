package com.example.apptender2.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.fragment.findNavController
import com.example.apptender2.R

class Home2Fragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home2, container, false)
        return view
        }
    override fun onViewCreated (view: View,savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val cardTienda= view.findViewById<ImageView>(R.id.tienda)
        cardTienda.setOnClickListener {
            findNavController().navigate(R.id.action_home2Fragment_to_homeFragment)

        }
    }
}