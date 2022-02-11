package com.example.fakeapplication_snapchat.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapplication_snapchat.*
import com.example.fakeapplication_snapchat.data.BAmigos
import com.example.fakeapplication_snapchat.data.BAmigosChat
import com.example.fakeapplication_snapchat.AmigosAdapter
import com.example.fakeapplication_snapchat.AmigosChatAdapter
import kotlinx.android.synthetic.main.activity_main.*

class ChatActivity : AppCompatActivity() {

    lateinit var listaAmigos: RecyclerView
    lateinit var listaAmigosChat: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        bottom_navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.chatFragment -> {
                    val i = Intent(this, ChatActivity::class.java)
                    startActivity(i);
                }
                R.id.storiesFragment -> {}
                R.id.discoverFragment -> {}
                R.id.cameraFragment -> {}
                R.id.mapFragment -> {}
            }
            true
        }
        listaAmigos = findViewById(R.id.rv_amigos)
        inicializarRecyclerView(
            BAmigos.data,
            this,
            listaAmigos
        )
        listaAmigosChat = findViewById(R.id.rv_chat)
        inicializarRecyclerViewChat(
            BAmigosChat.data,
            this,
            listaAmigosChat
        )
    }

    override fun onResume() {
        super.onResume()
    }
    fun inicializarRecyclerView(
        lista: ArrayList<BAmigos>,
        actividad: ChatActivity,
        recyclerView: RecyclerView
    ){
        val adaptador = AmigosAdapter(
            actividad,
            lista,
            recyclerView
        )
        recyclerView.adapter = adaptador
        recyclerView.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)
        recyclerView.setHasFixedSize(true)
        adaptador.notifyDataSetChanged()
    }
    fun inicializarRecyclerViewChat(
        lista: ArrayList<BAmigosChat>,
        actividad: ChatActivity,
        recyclerView: RecyclerView
    ){
        val adaptador = AmigosChatAdapter(
            actividad,
            lista,
            recyclerView
        )
        recyclerView.adapter = adaptador
        recyclerView.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)
        recyclerView.setHasFixedSize(true)
        adaptador.notifyDataSetChanged()
    }

}
