package com.example.fakeapplication_snapchat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapplication_snapchat.data.BDiscover
import com.example.fakeapplication_snapchat.ui.StoriesActivity

class SuscripcionesAdapter(private val contexto: StoriesActivity,
                           private val mDataSet: ArrayList<BDiscover>,
                           private val recyclerView: RecyclerView
):RecyclerView.Adapter<SuscripcionesAdapter.SuscripcionesViewHolder>() {
    inner class SuscripcionesViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imagen: ImageView
        val nombre: TextView
        init {
            nombre = view.findViewById(R.id.tv_nombreSuscripcion)
            imagen = view.findViewById(R.id.img_sucripciones)
        }
        fun bind(lista: BDiscover){
            nombre.setText(lista.nombre)
            imagen.setImageResource(lista.imagen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuscripcionesViewHolder {
        return SuscripcionesViewHolder(
            LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_suscripciones, parent, false))
    }

    override fun onBindViewHolder(holder: SuscripcionesViewHolder, position: Int) {
        val suscripciones = mDataSet[position]
        holder.bind(suscripciones)

    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }
}