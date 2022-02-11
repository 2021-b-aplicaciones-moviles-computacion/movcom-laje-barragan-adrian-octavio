package com.example.fakeapplication_snapchat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapplication_snapchat.data.Mensaje
import com.example.fakeapplication_snapchat.utils.Constants.RECEIVE_ID
import com.example.fakeapplication_snapchat.utils.Constants.SEND_ID
import kotlinx.android.synthetic.main.mensaje_item.view.*

class MensajeAdapter:RecyclerView.Adapter<MensajeAdapter.MensajeViewHolder>() {
    var mensajeList = mutableListOf<Mensaje>()
    var nombrePersona=""
    inner class MensajeViewHolder(view: View):RecyclerView.ViewHolder(view){
        val nombre: TextView = view.findViewById(R.id.text_gchat_user_other)
        init{
            view.setOnClickListener{
                mensajeList.removeAt(adapterPosition)
                notifyItemRemoved(adapterPosition)
            }
            nombre.setText(nombrePersona)
        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MensajeViewHolder {
        return MensajeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.mensaje_item, parent, false))
    }

    override fun onBindViewHolder(holder: MensajeViewHolder, position: Int) {
        val currentMessage = mensajeList[position]

        when (currentMessage.id) {
            SEND_ID -> {
                holder.itemView.tv_mensaje.apply {
                    text = currentMessage.mensaje
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_bot_mensaje.visibility = View.GONE
            }
            RECEIVE_ID -> {
                holder.itemView.tv_bot_mensaje.apply {
                    text = currentMessage.mensaje
                    visibility = View.VISIBLE
                }
                holder.itemView.tv_mensaje.visibility = View.GONE
            }
        }
    }

    override fun getItemCount(): Int {
        return mensajeList.size
    }
    fun insertarMensaje(mensaje: Mensaje){
        this.mensajeList.add(mensaje)
        notifyItemInserted(mensajeList.size)
    }
}