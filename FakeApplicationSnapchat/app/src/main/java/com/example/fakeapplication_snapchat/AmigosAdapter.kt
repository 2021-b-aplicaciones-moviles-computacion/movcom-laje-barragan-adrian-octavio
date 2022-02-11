package com.example.fakeapplication_snapchat

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapplication_snapchat.ui.ChatActivity
import com.example.fakeapplication_snapchat.data.BAmigos
import com.example.fakeapplication_snapchat.data.BAmigosChat


class AmigosAdapter(private val contexto: ChatActivity,
                    private var nuevalista: ArrayList<BAmigos>,
                    private val recyclerView: RecyclerView
): RecyclerView.Adapter<AmigosAdapter.AmigosViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AmigosViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.card_view_design, // Definimos la vista de nuestro recycler view
                parent,
                false,
            )
        return AmigosViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AmigosViewHolder, position: Int) {
        val amigos = nuevalista[position]
        holder.nombre.text = amigos.nombre
        holder.username.text = amigos.username
        holder.imagen.setImageResource(amigos.imagen)
        holder.eliminarAmigo(position)
        holder.agregarAmigo(amigos,position)
    }

    override fun getItemCount(): Int {
        return nuevalista.size
    }
    inner class AmigosViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val nombre: TextView
        val username: TextView
        val imagen: ImageView
        val botonEliminar: ImageView
        val botonAgregarAmigo: Button
        init {
            nombre = view.findViewById(R.id.txt_item1)
            username = view.findViewById(R.id.txt_item2)
            imagen = view.findViewById(R.id.imagen_person_amigos)
            botonEliminar = view.findViewById(R.id.btn_EliminarAmigo)
            botonAgregarAmigo = view.findViewById(R.id.btn_agregar)

        }
        fun agregarAmigo(amigo: BAmigos, index:Int){
            botonAgregarAmigo.setOnClickListener {
                BAmigosChat.data.add(BAmigosChat(amigo.nombre,amigo.username,amigo.imagen))
                nuevalista.removeAt(index)
                BAmigos.data.removeAt(index)
                notifyDataSetChanged()
            }
        }
        fun eliminarAmigo(index:Int){
            botonEliminar.setOnClickListener {
                nuevalista.removeAt(index)
                BAmigos.data.removeAt(index)
                notifyDataSetChanged()
                val toast = Toast.makeText(contexto, "Hello Javatpoint", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
    }


}

