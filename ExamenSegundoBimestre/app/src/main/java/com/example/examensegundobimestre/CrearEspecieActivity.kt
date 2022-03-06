package com.example.examensegundobimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class CrearEspecieActivity : AppCompatActivity() {
    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_especie)
        val botonCrearEspecie = findViewById<Button>(R.id.btnCrearNuevaEspecie)
       botonCrearEspecie.setOnClickListener {
            crearEspecie()
        }
        val botonRegresar = findViewById<Button>(R.id.buttonRegresarEspecie)
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
    fun crearEspecie() {
        val editTextNombre = findViewById<EditText>(R.id.txtnewNombreEspecie)
        val editTextPiel = findViewById<EditText>(R.id.txtNewPiel)
        val editTextNumero = findViewById<EditText>(R.id.txtNewNumero)
        val editTextPorcentajeEcuador = findViewById<EditText>(R.id.txtNewPorcentajeEcuador)
        radioGroup = findViewById(R.id.opciones_amamantan_crear)
        val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
        radioButton = findViewById(intSelectButton)
        var variable = false
        if (radioButton.text.toString() == "Si")
            variable = true
        val nuevaEspecie = hashMapOf<String, Any>(
            "nombre" to editTextNombre.text.toString(),
            "piel" to editTextPiel.text.toString(),
            "numeroEspecie" to editTextNumero.text.toString().toInt(),
            "porcentajeEcuador" to editTextPorcentajeEcuador.text.toString().toDouble(),
            "amamantan" to variable
        )
        val db = Firebase.firestore
        val referencia = db.collection("especies").document(editTextNombre.text.toString())
        referencia
            .set(nuevaEspecie)
            .addOnSuccessListener {
                editTextNombre.text.clear()
                editTextPiel.text.clear()
                editTextNumero.text.clear()
                editTextPorcentajeEcuador.text.clear()
            }
            .addOnFailureListener { }
    }
}