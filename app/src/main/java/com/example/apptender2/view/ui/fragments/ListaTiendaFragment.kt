package com.example.apptender2.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apptender2.R
import com.example.apptender2.view.adapter.tiendaAdapter


class ListaTiendaFragment : Fragment() {

    lateinit var recyclerTiend:RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_tienda, container, false)
        recyclerTiend=view.findViewById(R.id.recyclerTienda)
        val adapter=tiendaAdapter ()
        recyclerTiend.layoutManager=LinearLayoutManager(context)
        recyclerTiend.adapter=adapter
        return view
    }


    }
