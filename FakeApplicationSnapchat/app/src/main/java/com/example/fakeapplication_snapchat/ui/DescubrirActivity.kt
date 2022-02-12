package com.example.fakeapplication_snapchat.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.fakeapplication_snapchat.DescubirAdapter
import com.example.fakeapplication_snapchat.R
import com.example.fakeapplication_snapchat.data.BVideos
import kotlinx.android.synthetic.main.activity_main.*


class DescubrirActivity : AppCompatActivity() {
    lateinit var stories: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descubir)
        bottom_navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.chatFragment -> {
                    val i = Intent(this, ChatActivity::class.java)
                    startActivity(i);
                }
                R.id.storiesFragment -> {
                    val i = Intent(this, StoriesActivity::class.java)
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
        stories = findViewById(R.id.recycler_view_stories)
        inicializarRecyclerView(
            BVideos.data,
            this,
            stories
        )
    }
    fun inicializarRecyclerView(
        lista: ArrayList<BVideos>,
        actividad: DescubrirActivity,
        recyclerView: RecyclerView
    ){
        val adaptador = DescubirAdapter(
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