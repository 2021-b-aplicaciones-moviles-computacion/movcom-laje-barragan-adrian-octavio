package com.example.fakeapplication_snapchat.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.fakeapplication_snapchat.Fragments.*
import com.example.fakeapplication_snapchat.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val camaraFragmet = Camara()
    private val chatFragmet = ChatActivity()
    private val descubrirFragmet = Descubrir()
    private val mapaFragmet = Mapa()
    private val historiasFragmet = Stories()

    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_FakeApplicationSnapchat)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragmet(mapaFragmet)
        bottom_navigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.chatFragment -> {
                    val i = Intent(this, ChatActivity::class.java)
                    startActivity(i);
                }
                R.id.storiesFragment -> {
                    val i = Intent(this, StoriesActivity::class.java)
                    startActivity(i)
                }
                R.id.discoverFragment -> {
                    val i = Intent(this, DescubrirActivity::class.java)
                    startActivity(i)
                }
                R.id.cameraFragment -> {
                    val i = Intent(this, EscanearActivity::class.java)
                    startActivity(i)
                }
            }
            true
        }

    }
private  fun replaceFragmet(fragment: Fragment){
    val transaccion = supportFragmentManager.beginTransaction()
    transaccion.replace(R.id.fragment_container,fragment)
    transaccion.commit()
}

}