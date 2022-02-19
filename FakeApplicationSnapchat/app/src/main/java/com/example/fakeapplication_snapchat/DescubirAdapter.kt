package com.example.fakeapplication_snapchat

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapplication_snapchat.data.BVideos
import com.example.fakeapplication_snapchat.ui.DescubrirActivity


class DescubirAdapter(
    private val contexto: DescubrirActivity,
    private val mDataSet: ArrayList<BVideos>,
    private val recyclerView: RecyclerView
    ) : RecyclerView.Adapter<DescubirAdapter.DescubirViewHolder>() {



    // El layout manager invoca este método para renderizar cada elemento
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DescubirViewHolder {
        return DescubirViewHolder(LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_descubir, parent, false))
    }

    // Este método asigna valores para cada elemento de la lista
    override fun onBindViewHolder(holder: DescubirViewHolder, position: Int) {
        val videos = mDataSet[position]
        holder.bind(videos)
    }

    // Cantidad de elementos del RecyclerView
    // Puede ser más complejo (por ejm, si implementamos filtros o búsquedas)
    override fun getItemCount() = mDataSet.size

    inner class DescubirViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val nombre: TextView
        val descripcion: TextView
        val video: VideoView
        val botonFavoritos:ImageView
        init {
            nombre = view.findViewById(R.id.textVideoTitle)
            descripcion = view.findViewById(R.id.textVideoDescription)
            video = view.findViewById(R.id.videoView)
            botonFavoritos = view.findViewById(R.id.favorites)
            botonFavoritos.setOnClickListener {
                if(botonFavoritos.getTag() == "noAgregado"){
                    botonFavoritos.setImageResource(R.drawable.ic_favorite_agregado)
                    botonFavoritos.setTag("agregado")
                } else{
                    botonFavoritos.setImageResource(R.drawable.ic_favorite)
                    botonFavoritos.setTag("noAgregado")
                }
            }
        }
        fun bind(historia:BVideos){
            nombre.setText(historia.nombre)
            descripcion.setText(historia.descripcion)
            video.setVideoPath(historia.video)
            video.requestFocus()
            var opcion = "start"
            video.start()

            video.setOnClickListener {
                if ( opcion.equals("start")) {
                    video.pause()
                    opcion = "pause"
                }else{
                    video.start()
                    opcion = "start"
                }
            }


        }
    }
}