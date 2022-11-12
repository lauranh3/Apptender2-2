package com.example.apptender2.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.apptender2.R


class tiendaAdapter:RecyclerView.Adapter<tiendaAdapter.ViewHolder> (){

    override fun onCreateViewHolder(viewGroup:ViewGroup,int: Int):ViewHolder {
        val v=LayoutInflater.from(viewGroup.context).inflate(R.layout.card_view_tienda,viewGroup,false)
        return ViewHolder (v)
    }
    inner class  ViewHolder (ItemView: View):RecyclerView.ViewHolder(ItemView){
        var itemImage: ImageView
        var itemTitle: TextView
        var itemPrecio  : TextView

        init {
            itemImage=ItemView.findViewById(R.id.image)
            itemTitle=ItemView.findViewById(R.id.Title)
            itemPrecio=ItemView.findViewById(R.id.Precio)

        }
    }


    val title= arrayOf("Bananos","Fresas","Tomates","Papas","Brocoli","Mango" )
    val precio= arrayOf("$3.000","$3.900","$2.500", "$1.500","$15.000", "$4500" )
        val image= arrayOf(R.drawable.banano,R.drawable.fresas,R.drawable.tomate1,R.drawable.papa,R.drawable.brocoli,R.drawable.mango)

    override fun onBindViewHolder(viewHolder: ViewHolder, i:Int) {
        viewHolder.itemTitle.text=title [i]
        viewHolder.itemPrecio.text=precio [i]
        viewHolder.itemImage.setImageResource(image[i])

    }

    override fun getItemCount(): Int {
        return title.size

    }
}