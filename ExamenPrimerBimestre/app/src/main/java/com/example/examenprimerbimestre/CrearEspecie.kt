package com.example.examenprimerbimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class CrearEspecie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_especie)
        val nombreEspecie = findViewById<EditText>(R.id.txtnewNombreEspecie)
        val pielEspecie = findViewById<EditText>(R.id.txtNewPiel)
        val amamantanEspecie = findViewById<RadioButton>(R.id.rdb_DomesticadoTrue)
        val pesoMaxEspecie = findViewById<EditText>(R.id.txtNewPeso)
        val numeroEspecie = findViewById<EditText>(R.id.txtNewNumero)
        val boton = findViewById<Button>(R.id.btnCrearNuevaRaza)
        var amamantan = false
        if(amamantanEspecie.isChecked){
            amamantan = true
        }
        boton
            .setOnClickListener { devolverRespuesta(nombreEspecie.getText().toString(),
            pielEspecie.getText().toString(), amamantan, pesoMaxEspecie.getText().toString(), numeroEspecie.getText().toString()) }
    }
    fun devolverRespuesta(nombre:String, piel:String,amamantan:Boolean, peso:String, numero:String){
        val intentDevolverParametros = Intent()
        intentDevolverParametros.putExtra("nuevaNombreEspecie",nombre )
        intentDevolverParametros.putExtra("nuevaPielEspecie",piel )
        intentDevolverParametros.putExtra("nuevaAmamantanEspecie",amamantan )
        intentDevolverParametros.putExtra("nuevaPesoEspecie",peso )
        intentDevolverParametros.putExtra("nuevaNumeroEspecie",numero )
        setResult(
            RESULT_OK,
            intentDevolverParametros
        )
        finish()
    }

}