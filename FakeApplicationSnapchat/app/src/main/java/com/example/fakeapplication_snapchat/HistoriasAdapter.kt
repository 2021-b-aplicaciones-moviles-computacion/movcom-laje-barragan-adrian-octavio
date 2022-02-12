package com.example.fakeapplication_snapchat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapplication_snapchat.data.BDiscover
import com.example.fakeapplication_snapchat.ui.StoriesActivity

class HistoriasAdapter(private val contexto: StoriesActivity,
                       private val mDataSet: ArrayList<BDiscover>,
                       private val recyclerView: RecyclerView
): RecyclerView.Adapter<HistoriasAdapter.HistoriasViewHolder>() {
    inner class HistoriasViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val imagen: ImageView
        val nombre: TextView
        init {
            nombre = view.findViewById(R.id.tv_nombreHistoria)
            imagen = view.findViewById(R.id.iv_historia)
        }
        fun bind(lista: BDiscover) {
            nombre.setText(lista.nombre)
            imagen.setImageResource(lista.imagen)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoriasViewHolder {
        return HistoriasViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_historias, parent, false))
    }

    override fun onBindViewHolder(holder: HistoriasViewHolder, position: Int) {
        val historias = mDataSet[position]
        holder.bind(historias)

    }

    override fun getItemCount(): Int {
        return mDataSet.size
    }
}