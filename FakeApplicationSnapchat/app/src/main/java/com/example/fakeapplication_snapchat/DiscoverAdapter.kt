package com.example.fakeapplication_snapchat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import android.widget.ImageView
import com.example.fakeapplication_snapchat.data.BDiscover
import com.example.fakeapplication_snapchat.data.BVideos
import com.example.fakeapplication_snapchat.ui.DescubrirActivity
import com.example.fakeapplication_snapchat.ui.StoriesActivity


class DiscoverAdapter(
    private val contexto: StoriesActivity,
    private val mDataSet: ArrayList<BDiscover>,
    private val recyclerView: RecyclerView
): RecyclerView.Adapter<DiscoverAdapter.DiscoverViewHolder>() {

    val miNuevaLista =mDataSet

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DiscoverAdapter.DiscoverViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_disover, // Definimos la vista de nuestro recycler view
                parent,
                false,
            )
        return DiscoverViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DiscoverAdapter.DiscoverViewHolder, position: Int) {
        val discover = miNuevaLista[position]
        holder.imgMusica.setImageResource(discover.imagen)
        holder.tvNombre.setText(discover.nombre)
    }

    override fun getItemCount(): Int {
        return miNuevaLista.size
    }
    inner class DiscoverViewHolder(view: View):RecyclerView.ViewHolder(view) {
        val imgMusica: ImageView
        val tvNombre: TextView
        init {
             imgMusica = view.findViewById(R.id.img_discover)
             tvNombre = view.findViewById(R.id.tv_nombreDiscover)
        }
    }

}

