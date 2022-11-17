package com.example.apptender2.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apptender2.R
import com.example.apptender2.view.adapter.tiendaAdapter
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase




@Suppress("DEPRECATION")
class ListaTiendaFragment : Fragment() {

    lateinit var recyclerTiend: RecyclerView
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        firebaseAuth = Firebase.auth
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_tienda, container, false)
        recyclerTiend = view.findViewById(R.id.recyclerTienda)
        val adapter = tiendaAdapter()
        recyclerTiend.layoutManager = LinearLayoutManager(context)
        recyclerTiend.adapter = adapter
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btm = view.findViewById<BottomNavigationView>(R.id.buttonnavigation)
        btm.setOnNavigationItemReselectedListener {
            when (it.itemId) {
                R.id.Home -> findNavController().navigate(R.id.action_listaTiendaFragment_to_home2Fragment)
                R.id.Perf -> findNavController().navigate(R.id.action_listaTiendaFragment_to_misdatosFragment)
                R.id.Map -> findNavController().navigate(R.id.action_listaTiendaFragment_to_mapasFragment)
                R.id.cerrar -> {
                    firebaseAuth.signOut()
                    findNavController().navigate(R.id.action_homeFragment_to_loginActivity)
                    true


                }
            }
        }
    }
}

