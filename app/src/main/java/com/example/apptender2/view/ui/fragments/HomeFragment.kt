package com.example.apptender2.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.apptender2.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth


@Suppress("DEPRECATION", "UNUSED_EXPRESSION")
class HomeFragment : Fragment() {
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cardBanana = view.findViewById<ImageView>(R.id.Banano)
        cardBanana.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_bananosFragment)
        }

        val cardFresa = view.findViewById<ImageView>(R.id.Fresas)
        cardFresa.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_fresasFragment)

            val btm = view.findViewById<BottomNavigationView>(R.id.buttonnavigation)
            btm.setOnNavigationItemReselectedListener {
                when (it.itemId) {
                    R.id.Home -> findNavController().navigate(R.id.action_homeFragment_to_home2Fragment)
                    R.id.Perf -> findNavController().navigate(R.id.action_homeFragment_to_misdatosFragment)
                    R.id.Map -> findNavController().navigate(R.id.action_homeFragment_to_mapasFragment)
                    R.id.homeFragment -> findNavController().navigate(R.id.action_homeFragment_self)
                    R.id.cerrar -> {
                        firebaseAuth.signOut()
                        findNavController().navigate(R.id.action_homeFragment_to_loginActivity)
                        true
                    }


                }
    }
            }
        }
        }

