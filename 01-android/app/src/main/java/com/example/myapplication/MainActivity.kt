package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity() : AppCompatActivity() {
    val CODIGO_RESPUESTA_INTENT_EXPLICITO = 401
    var resultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK){

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botonCicloVida = findViewById<Button>(R.id.btn_ir_ciclo_vida)
        botonCicloVida
            .setOnClickListener {
                irActividad(ACicloVida::class.java)
            }
        val botonListView = findViewById<Button>(R.id.btn_ir_list_view)
        botonListView
            .setOnClickListener {
                irActividad(BListView::class.java)
            }
        val botonIntent = findViewById<Button>(R.id.btn_intent)
        botonListView
            .setOnClickListener {
                irActividad(BListView::class.java)
            }

    }
    fun irActividadConParametros(
        clase: Class<*>){
        val intentExplicito = Intent(this, clase)
        //Enviar parametros (Solamente variable primitivas)
        intentExplicito.putExtra("nombre", "Adrian")
        intentExplicito.putExtra("apellido", "Eguez")
        intentExplicito.putExtra("edad", "32")
        resultLauncher.launch(intent)
        //startActivityForResult(intent,CODIGO_RESPUESTA_INTENT_EXPLICITO)
    }
    fun irActividad(
        clase: Class<*>){
        val intent = Intent(this, clase)
        startActivity(intent)
    }
}