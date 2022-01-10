package com.example.examenprimerbimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView

class EditarEspecie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_especie)
        val titulo = findViewById<TextView>(R.id.textNombreEspecie)
        val nombreEspecie = findViewById<EditText>(R.id.txtnewNombreRaza)
        val pielEspecie = findViewById<EditText>(R.id.txtEditPiel)
        val amamantanEspecie = findViewById<RadioButton>(R.id.rdb_Edittrue)
        val pesoMaxEspecie = findViewById<EditText>(R.id.txtEditPeso)
        val numeroEspecie = findViewById<EditText>(R.id.txtEditNumero)
        val boton = findViewById<Button>(R.id.btnCrearNuevaRaza)
        var amamantan = false
        if(amamantanEspecie.isChecked){
            amamantan = true
        }
        val bundle = intent.extras
        var indice = bundle?.getString("idEspecieEditar")
        if (indice == null)
            indice = ""
        titulo.setText("$indice")
        boton.setOnClickListener {
            editarEspecie(indice, nombreEspecie, pielEspecie,amamantan, pesoMaxEspecie, numeroEspecie)
            abrirActividad(Especie::class.java)
        }

        }
    fun editarEspecie(
        nombre: String,
        nombreEspecie: EditText,
        pielEspecie: EditText,
        amamantan: Boolean,
        pesoMaxEspecie: EditText,
        numeroEspecie: EditText
    ) {
        BBaseDatosMemoria.arregloBEspecie.filter { it.nombre == nombre }
            .map {
                it.nombre = nombreEspecie.text.toString()
                it.piel =pielEspecie.text.toString()
                it.amamantan = amamantan
                it.porcentajeEcuador = pesoMaxEspecie.text.toString().toDouble()
                it.numeroEspecie = numeroEspecie.text.toString().toInt()
            }
    }

    private fun abrirActividad(
        clase: Class<*>,

    ) {
        val i = Intent(this, clase)
        startActivity(i);
    }

}


