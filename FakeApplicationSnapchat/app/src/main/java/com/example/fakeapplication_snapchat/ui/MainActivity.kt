package com.example.fakeapplication_snapchat.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fakeapplication_snapchat.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.Theme_FakeApplicationSnapchat)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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

}