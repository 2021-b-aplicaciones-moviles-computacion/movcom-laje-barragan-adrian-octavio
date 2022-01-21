package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GRecyclerView : AppCompatActivity() {
    var totalLikes = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grecycler_view)
        val listaEntrenador = arrayListOf<BEntrenador>()
        listaEntrenador.add(
            BEntrenador("Adrian",
                "1714656647"
        )

        )
        listaEntrenador.add( BEntrenador(
            "Jose",
            "2354789963"
        ))
        val recyclerViewBEntrenador = findViewById<RecyclerView>(R.id.rv_entrenadores)
        inicializarRecyclerView(listaEntrenador,this, recyclerViewBEntrenador);
    }
    fun inicializarRecyclerView(
        lista: List<BEntrenador>,
        actividad: GRecyclerView,
        recyclerView: RecyclerView
    ) {
        val adaptador = FRecyclerViewAdaptadorNombreCedula(
            actividad, lista, recyclerView
        )
        recyclerView.adapter = adaptador
        recyclerView.itemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(actividad)
        adaptador.notifyDataSetChanged()
    }
    fun aumentarTotalLikes(){
        totalLikes = totalLikes + 1
        val textView = findViewById<TextView>(R.id.tx_total_likes)
        textView.text = totalLikes.toString()
    }

}