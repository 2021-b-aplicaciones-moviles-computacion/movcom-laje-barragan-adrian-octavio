package com.example.examensegundobimestre

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class EditarRazaActivity : AppCompatActivity() {
    var radioGroup: RadioGroup? = null
    lateinit var radioButton: RadioButton
    var nombreEspecie = ""
    val db = Firebase.firestore
    val referencia = db.collection("especies")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_editar_raza)
        val titulo = findViewById<TextView>(R.id.textTituloEditarRaza)
        val nombreRaza = findViewById<EditText>(R.id.txtUpdateNombreRaza)
        val nombreCientificoRaza = findViewById<EditText>(R.id.txtUpdateNombreCientifico)
        val alimnentacionRaza = findViewById<EditText>(R.id.txtUpdateAlimnentacionRaza)
        val esperanzaVida = findViewById<EditText>(R.id.txtUpdateEsperanzaVida)
        val radioButtonRazaSi = findViewById<RadioButton>(R.id.radio_si_editar_raza)
        val radioButtonRazaNo = findViewById<RadioButton>(R.id.radio_no_editar_raza)
        val bundle = intent.extras
        var indice = bundle?.getString("idRazaEditar")
        nombreEspecie = bundle?.getString("nombreEspecie").toString()
        if (indice == null)
            indice = ""
        titulo.setText("$indice")
        referencia.document(nombreEspecie).collection("razas").document(indice)
            .get()
            .addOnSuccessListener { document  ->
            if (document != null) {
                nombreRaza.setText("${document.data?.get("nombreRaza").toString()}")
                nombreCientificoRaza.setText("${document.data?.get("nombreCientifico").toString()}")
                alimnentacionRaza.setText("${document.data?.get("alimentacion").toString()}")
                esperanzaVida.setText("${document.data?.get("esperanzaVida").toString().toInt()}")
                radioButtonRazaSi.isChecked = document.data?.get("domesticado").toString().toBoolean()
                radioButtonRazaNo.isChecked = !document.data?.get("domesticado").toString().toBoolean()
            } else {
                Log.d("TAG", "No such document")
            }
        }
        val botonEditarEspecie = findViewById<Button>(R.id.btnUpdateRaza)
        botonEditarEspecie.setOnClickListener {
            editarRaza(indice)
        }
    }
    fun abrirActividad(
        clase: Class<*>
    ) {
        val intentExplicito = Intent(this, clase)
        intentExplicito.putExtra("idEspecie", "$nombreEspecie")
        startActivity(intentExplicito)
    }
    private fun editarRaza(indice: String) {
        val nombreRaza = findViewById<EditText>(R.id.txtUpdateNombreRaza)
        val nombreCientificoRaza = findViewById<EditText>(R.id.txtUpdateNombreCientifico)
        val alimnentacionRaza = findViewById<EditText>(R.id.txtUpdateAlimnentacionRaza)
        val esperanzaVida = findViewById<EditText>(R.id.txtUpdateEsperanzaVida)
        radioGroup = findViewById(R.id.opciones_amamantan_editar)
        val intSelectButton: Int = radioGroup!!.checkedRadioButtonId
        radioButton = findViewById(intSelectButton)
        var variable = false
        if (radioButton.text.toString() == "Si")
            variable = true
        val especie = hashMapOf<String, Any>(
            "nombreRaza" to nombreRaza.text.toString(),
            "nombreCientifico" to nombreCientificoRaza.text.toString(),
            "alimentacion" to alimnentacionRaza.text.toString(),
            "esperanzaVida" to esperanzaVida.text.toString().toInt(),
            "domesticado" to variable
        )
        referencia.document(nombreEspecie).collection("razas").document(indice)
            .update(especie)
            .addOnSuccessListener {
                abrirActividad(RazaActivity::class.java)
            }
            .addOnFailureListener { }
    }
}