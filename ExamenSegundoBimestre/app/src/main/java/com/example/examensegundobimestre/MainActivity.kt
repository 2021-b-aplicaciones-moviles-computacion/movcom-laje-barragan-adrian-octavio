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
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import com.example.examensegundobimestre.model.BEspecie
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    var idItemSeleccionado: Int = 0
    val mListaEspecies = ArrayList<BEspecie>()
    val db = Firebase.firestore
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnCrearEspecie = findViewById<Button>(R.id.btnCrearEspecie)
        btnCrearEspecie.setOnClickListener {
                abrirActividad(CrearEspecieActivity::class.java)
        }
        val referencia = db.collection("especies")
            .get()
            .addOnSuccessListener { result ->
                    for (document in result) {
                        mListaEspecies.add(BEspecie(document.data.get("nombre").toString(),
                        document.data.get("piel").toString(),
                        document.data.get("amamantan").toString().toBoolean(),
                            document.data.get("porcentajeEcuador").toString().toDouble(),
                            document.data.get("numeroEspecie").toString().toInt()))
                }
                val listView = findViewById<ListView>(R.id.lv_list_view)
                val adaptador = ArrayAdapter(
                    this, // Contexto
                    android.R.layout.simple_list_item_1, // como se va a ver (XML)
                    mListaEspecies
                )
                listView.adapter = adaptador
                registerForContextMenu(listView)
                adaptador.notifyDataSetChanged()
            }
            .addOnFailureListener { exception ->
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
        inflater.inflate(R.menu.menu_epecie, menu)
        val info = menuInfo as AdapterView.AdapterContextMenuInfo
        val id = info.position
        idItemSeleccionado = id
    }
    override fun onContextItemSelected(
        item: MenuItem,
    ): Boolean {
        return when (item.itemId) {
            R.id.mi_editar -> {
                val i = Intent(this, EditarEspecieActivity::class.java)
                i.putExtra("idEspecieEditar", "${mListaEspecies[idItemSeleccionado].nombre}");
                startActivity(i);
                return true
            }
            R.id.mi_eliminar -> {
                elimarEspecie()
                return true
            }
            R.id.mi_ver_raza -> {
                val i = Intent(this, RazaActivity::class.java)
                i.putExtra("idEspecie", "${mListaEspecies[idItemSeleccionado].nombre}");
                startActivity(i)
                return true
            }
            else -> super.onContextItemSelected(item)
        }
    }
    fun elimarEspecie(){
        val builder = AlertDialog.Builder(this)
        val auxArray = arrayListOf<String>()
        val referencia = db.collection("especies")
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
                    val referencia2 = db.collection("especies").document("${auxArray[idItemSeleccionado]}")
                        .delete()
                        .addOnSuccessListener { Log.d("TAG", "DocumentSnapshot successfully deleted!") }
                        .addOnFailureListener { e -> Log.w("TAG", "Error deleting document", e) }
                    mListaEspecies.removeAt(idItemSeleccionado)
                    val listView = findViewById<ListView>(R.id.lv_list_view)
                    val adaptador = ArrayAdapter(
                        this, // Contexto
                        android.R.layout.simple_list_item_1,
                        mListaEspecies// como se va a ver (XML)
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
