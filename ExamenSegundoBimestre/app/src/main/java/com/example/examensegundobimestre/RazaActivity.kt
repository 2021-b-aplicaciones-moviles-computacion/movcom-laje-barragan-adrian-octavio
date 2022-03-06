package com.example.examensegundobimestre

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.*
import com.example.examensegundobimestre.model.BEspecie
import com.example.examensegundobimestre.model.BRaza
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class RazaActivity : AppCompatActivity() {
    var idItemSeleccionado = 0
    var nombreEspecie = ""
    val mListaRazas = ArrayList<BRaza>()
    val db = Firebase.firestore
    val referencia = db.collection("especies")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_raza)
        val titulo = findViewById<TextView>(R.id.textView_raza)
        val listView = findViewById<ListView>(R.id.lv_list_view)
        val botonRegresar = findViewById<Button>(R.id.btnRegresarRaza)
        botonRegresar.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }
        val bundle = intent.extras
        nombreEspecie = bundle?.getString("idEspecie").toString()
        if (nombreEspecie == null)
            nombreEspecie = ""
        titulo.setText("$nombreEspecie")
        val botonCrearRaza = findViewById<Button>(R.id.btnCrearRaza)
        botonCrearRaza
            .setOnClickListener {
                val i = Intent(this, CrearRazaActivity::class.java)
                i.putExtra("idEspecieCrear", "$nombreEspecie")
                startActivity(i)
            }
        referencia.document(nombreEspecie).collection("razas")
            .get().addOnSuccessListener { result ->
                for (document in result) {
                    mListaRazas.add(
                        BRaza(
                            document.data.get("nombreRaza").toString(),
                            document.data.get("nombreCientifico").toString(),
                            document.data.get("alimentacion").toString(),
                            document.data.get("esperanzaVida").toString().toInt(),
                            document.data.get("domesticado").toString().toBoolean()
                        )
                    )
                }
                val adaptador = ArrayAdapter(
                    this, // Contexto
                    android.R.layout.simple_list_item_1, // como se va a ver (XML)
                    mListaRazas
                )
                listView.adapter = adaptador
                registerForContextMenu(listView)
                adaptador.notifyDataSetChanged()
            }
    }
    fun abrirActividad(
        clase: Class<*>
    ) {
        val intentExplicito = Intent(this, clase)
        startActivity(intentExplicito)
    }
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_raza, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        idItemSeleccionado = id
    }
    override fun onContextItemSelected(
        item: MenuItem,
    ): Boolean {
        return when (item.itemId) {
            R.id.mi_editar -> {
                val i = Intent(this, EditarRazaActivity::class.java)
                i.putExtra("nombreEspecie", "${nombreEspecie}");
                i.putExtra("idRazaEditar", "${mListaRazas[idItemSeleccionado].nombreRaza}");
                startActivity(i);
                return true
            }
            R.id.mi_eliminar -> {
                elimarRaza()
                return true
            }
            R.id.mi_ver_raza -> {
                val i = Intent(this, RazaActivity::class.java)
                i.putExtra("idRaza", "${mListaRazas[idItemSeleccionado].nombreRaza}");
                startActivity(i)
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }
    fun elimarRaza(){
        val builder = AlertDialog.Builder(this)
        val auxArray = arrayListOf<String>()
        referencia.document(nombreEspecie).collection("razas")
            .get()
            .addOnSuccessListener {result ->
                for (document in result){
                    auxArray.add(document.id)
                }
                Log.d("salida", "id = ${auxArray[idItemSeleccionado]}")
            }
        builder.setMessage("Desea eliminar")
            .setPositiveButton("Aceptar",
                DialogInterface.OnClickListener{ dialog, id ->
                    referencia.document(nombreEspecie).collection("razas").document("${auxArray[idItemSeleccionado]}")
                        .delete()
                        .addOnSuccessListener { Log.d("TAG", "DocumentSnapshot successfully deleted!") }
                        .addOnFailureListener { e -> Log.w("TAG", "Error deleting document", e) }
                    mListaRazas.removeAt(idItemSeleccionado)
                    val listView = findViewById<ListView>(R.id.lv_list_view)
                    val adaptador = ArrayAdapter(
                        this, // Contexto
                        android.R.layout.simple_list_item_1,
                        mListaRazas
                    )
                    listView.adapter = adaptador
                })
            .setNegativeButton("Cancelar",
                DialogInterface.OnClickListener { dialog, id ->
                    // User cancelled the dialog
                })
        // Create the AlertDialog object and return it
        val dialogo = builder.create()
        dialogo.show()
    }
}