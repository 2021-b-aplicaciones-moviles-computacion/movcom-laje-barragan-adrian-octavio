package com.example.examensegundobimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CrearRazaActivity : AppCompatActivity() {
    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton
    val db = Firebase.firestore
    val referencia = db.collection("especies")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_raza)
        val bundle = intent.extras
        var especie = bundle?.getString("idEspecieCrear")
        val botonCrearRaza = findViewById<Button>(R.id.btnCrearRazaNueva)
        botonCrearRaza.setOnClickListener {
            if (especie != null) {
                crearRaza(especie)
            }
        }
        val botonRegresar = findViewById<Button>(R.id.btnRegresarCrearRazaToRaza)
        botonRegresar.setOnClickListener {
            abrirActividad(RazaActivity::class.java, especie)
        }

    }

    fun abrirActividad(
        clase: Class<*>,
        especie: String?
    ) {
        val intentExplicito = Intent(this, clase)
        intentExplicito.putExtra("idEspecie", "$especie")
        startActivity(intentExplicito)
    }
    fun crearRaza(especie: String) {
        val editTextNombre = findViewById<EditText>(R.id.txtnewNombreRaza)
        val editTextNombreCientifico = findViewById<EditText>(R.id.txtNewNombreCientifico)
        val editTextAlimentacion = findViewById<EditText>(R.id.txtNewAlimentacion)
        val editTextEsperanzaVida = findViewById<EditText>(R.id.txtNewEsperanzaVida)
        radioGroup = findViewById(R.id.opciones_domesticar_crear)
        val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
        radioButton = findViewById(intSelectButton)
        var variable = false
        if (radioButton.text.toString() == "Si")
            variable = true
        val nuevaRaza = hashMapOf<String, Any>(
            "nombreRaza" to editTextNombre.text.toString(),
            "nombreCientifico" to editTextNombreCientifico.text.toString(),
            "alimentacion" to editTextAlimentacion.text.toString(),
            "esperanzaVida" to editTextEsperanzaVida.text.toString().toInt(),
            "domesticado" to variable
        )
        referencia.document(especie).collection("razas").document(editTextNombre.text.toString())
            .set(nuevaRaza)
            .addOnSuccessListener {
                editTextNombre.text.clear()
                editTextNombreCientifico.text.clear()
                editTextAlimentacion.text.clear()
                editTextEsperanzaVida.text.clear()
            }
            .addOnFailureListener { }
    }
}