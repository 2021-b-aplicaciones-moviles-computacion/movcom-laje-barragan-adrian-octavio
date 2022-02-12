package com.example.fakeapplication_snapchat.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapplication_snapchat.DiscoverAdapter
import com.example.fakeapplication_snapchat.HistoriasAdapter
import com.example.fakeapplication_snapchat.R
import com.example.fakeapplication_snapchat.SuscripcionesAdapter
import com.example.fakeapplication_snapchat.data.BDiscover
import kotlinx.android.synthetic.main.activity_main.*


class StoriesActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stories)
        bottom_navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.chatFragment -> {
                    val i = Intent(this, ChatActivity::class.java)
                    startActivity(i);
                }
                R.id.discoverFragment -> {
                    val i = Intent(this, DescubrirActivity::class.java)
                    startActivity(i)
                }
                R.id.cameraFragment -> {
                    val i = Intent(this, EscanearActivity::class.java)
                    startActivity(i)
                }
                R.id.mapFragment -> {
                    val i = Intent(this, MainActivity::class.java)
                    startActivity(i)
                }
            }
            true
        }
        val data: ArrayList<BDiscover> = ArrayList()
        data.add(BDiscover("Eeevee Enara", "eevee", R.drawable.img_spider_man_vertical))
        data.add(BDiscover("Sadie Crowel", "Sadie", R.drawable.img_spider_man_vertical))
        data.add(BDiscover("Chinki Minki", "Chinki", R.drawable.img_spider_man_vertical))
        data.add(BDiscover("Lea Elui G", "Elui", R.drawable.img_spider_man_vertical))
        data.add(BDiscover("Like Hacks ","Like", R.drawable.img_spider_man_vertical))
        data.add(BDiscover("Amulya Rattan", "Amulya", R.drawable.img_spider_man_vertical))
        val myListRecyclerView: RecyclerView = findViewById(R.id.rv_discover)
        inicializarRecyclerView(data,this,myListRecyclerView )
        val myListRecyclerView2: RecyclerView = findViewById(R.id.recyclerView_sucripciones)
        val adaptador = SuscripcionesAdapter(
            this,
            data,
            myListRecyclerView2
        )
        myListRecyclerView2.adapter = adaptador
        myListRecyclerView2.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        myListRecyclerView2.setHasFixedSize(true)
        adaptador.notifyDataSetChanged()
        val data2: ArrayList<BDiscover> = ArrayList()
        data2.add(BDiscover("Adrian", "Adrian", R.drawable.story_to_view))
        data2.add(BDiscover("Mark", "Mark", R.drawable.story_to_view_1))
        data2.add(BDiscover("Selena", "Selena", R.drawable.story_to_view_2))
        data2.add(BDiscover("Luisito", "Luisito", R.drawable.story_to_view_3))
        data2.add(BDiscover("Raúl", "Raúl", R.drawable.story_to_view_4))
        val myListRecyclerView3: RecyclerView = findViewById(R.id.rv_historias)
        val adaptador2 = HistoriasAdapter(
            this,
            data2,
            myListRecyclerView3
        )
        myListRecyclerView3.adapter = adaptador2
        myListRecyclerView3.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        myListRecyclerView3.setHasFixedSize(true)
        adaptador2.notifyDataSetChanged()


    }
    fun inicializarRecyclerView(
        lista: ArrayList<BDiscover>,
        actividad: StoriesActivity,
        recyclerView: RecyclerView
    ){

        val adaptador = DiscoverAdapter(
            actividad,
            lista,
            recyclerView
        )
        recyclerView.adapter = adaptador
        recyclerView.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recyclerView.layoutManager = androidx.recyclerview.widget.GridLayoutManager(actividad,2)
        recyclerView.setHasFixedSize(true)
        adaptador.notifyDataSetChanged()
    }

}