package com.example.fakeapplication_snapchat

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapplication_snapchat.ui.ChatActivity
import com.example.fakeapplication_snapchat.data.BAmigosChat
import com.example.fakeapplication_snapchat.ui.MensajeActivity

class AmigosChatAdapter(
    private val contexto: ChatActivity,
    private val nuevalista: ArrayList<BAmigosChat>,
    private val recyclerView: RecyclerView
): RecyclerView.Adapter<AmigosChatAdapter.ChatAmigosAdapterViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ChatAmigosAdapterViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.rv_chat, // Definimos la vista de nuestro recycler view
                parent,
                false,
            )
        return ChatAmigosAdapterViewHolder(itemView)
    }

    override fun onBindViewHolder(
        holder: ChatAmigosAdapterViewHolder,
        position: Int
    ) {
        val amigos = nuevalista[position]
        holder.nombre.text = amigos.nombre
        holder.imagen.setImageResource(amigos.imagen)
        holder.nombre.setOnClickListener {
            val i =  Intent(contexto, MensajeActivity::class.java)
            i.putExtra("nombre","${amigos.nombre}")
            contexto.startActivity(i)
        }
    }

    override fun getItemCount(): Int {
        return nuevalista.size
    }
    inner class ChatAmigosAdapterViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nombre: TextView
        val imagen: ImageView
        init {
            nombre = view.findViewById(R.id.txt_item3)
            imagen = view.findViewById(R.id.imageView_iconPersonChat)

        }

    }
}