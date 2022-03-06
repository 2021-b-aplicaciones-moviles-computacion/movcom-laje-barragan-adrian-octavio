package com.example.examensegundobimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EditarEspecieActivity : AppCompatActivity() {
    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton
    val db = Firebase.firestore
    val especies = db.collection("especies")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_especie)
        val titulo = findViewById<TextView>(R.id.textEditNombreEspecie)
        val nombreEspecie = findViewById<EditText>(R.id.txtEditNombreEspecie)
        val pielEspecie = findViewById<EditText>(R.id.txtEditPiel)
        val porcentajeEspecie = findViewById<EditText>(R.id.txtEditPorcentaje)
        val numeroEspecie = findViewById<EditText>(R.id.txtEditNumero)
        val radioButtonEspecieSi = findViewById<RadioButton>(R.id.radio_si_editar_especie)
        val radioButtonEspecieNo = findViewById<RadioButton>(R.id.radio_no_editar_especie)
        val bundle = intent.extras
        var indice = bundle?.getString("idEspecieEditar")
        if (indice == null)
            indice = ""
        titulo.setText("$indice")
        val documento = especies.document("$indice")
        documento.get().addOnSuccessListener { document  ->
            if (document != null) {
                nombreEspecie.setText("${document.data?.get("nombre").toString()}")
                pielEspecie.setText("${document.data?.get("piel").toString()}")
                porcentajeEspecie.setText("${document.data?.get("porcentajeEcuador").toString().toDouble()}")
                numeroEspecie.setText("${document.data?.get("numeroEspecie").toString().toInt()}")
                radioButtonEspecieSi.isChecked = document.data?.get("amamantan").toString().toBoolean()
                radioButtonEspecieNo.isChecked = !document.data?.get("amamantan").toString().toBoolean()
            } else {
                Log.d("TAG", "No such document")
            }
        }
        val botonEditarEspecie = findViewById<Button>(R.id.btnEditarEspecie)
        botonEditarEspecie.setOnClickListener {
            editarEspecie(indice)
        }
        val botonRegresar = findViewById<Button>(R.id.btnRegresarEditToEspecie)
        botonRegresar.setOnClickListener {
            abrirActividad(MainActivity::class.java)
        }
    }
    fun abrirActividad(
        clase: Class<*>
    ) {
        val intentExplicito = Intent(this, clase)
        startActivity(intentExplicito)
    }
    fun editarEspecie(
        indice: String
    ) {
        val editTextNombre = findViewById<EditText>(R.id.txtEditNombreEspecie)
        val editTextPiel = findViewById<EditText>(R.id.txtEditPiel)
        val editTextNumero = findViewById<EditText>(R.id.txtEditNumero)
        val editTextPorcentajeEcuador = findViewById<EditText>(R.id.txtEditPorcentaje)
        radioGroup = findViewById(R.id.rdg_domesicado_editar_especie)
        val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
        radioButton = findViewById(intSelectButton)
        var variable = false
        if (radioButton.text.toString() == "Si")
            variable = true
        val especie = hashMapOf<String, Any>(
            "nombre" to editTextNombre.text.toString(),
            "piel" to editTextPiel.text.toString(),
            "numeroEspecie" to editTextNumero.text.toString().toInt(),
            "porcentajeEcuador" to editTextPorcentajeEcuador.text.toString().toDouble(),
            "amamantan" to variable
        )
        val db = Firebase.firestore
        val referencia = db.collection("especies").document(indice)
        referencia
            .update(especie)
            .addOnSuccessListener {
                abrirActividad(MainActivity::class.java)
            }
            .addOnFailureListener { }
    }
}