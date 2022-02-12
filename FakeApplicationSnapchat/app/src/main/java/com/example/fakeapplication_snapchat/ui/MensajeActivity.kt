package com.example.fakeapplication_snapchat.ui

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakeapplication_snapchat.MensajeAdapter
import com.example.fakeapplication_snapchat.R
import com.example.fakeapplication_snapchat.data.Mensaje
import com.example.fakeapplication_snapchat.utils.Constants.RECEIVE_ID
import com.example.fakeapplication_snapchat.utils.Constants.SEND_ID
import com.example.fakeapplication_snapchat.utils.BotResponse
import com.example.fakeapplication_snapchat.utils.Constants.OPEN_GOOGLE
import com.example.fakeapplication_snapchat.utils.Constants.OPEN_SEARCH
import com.example.fakeapplication_snapchat.utils.Time
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_mensaje.*
import kotlinx.coroutines.*

class MensajeActivity : AppCompatActivity() {
    private val TAG = "MainActivity"

    //You can ignore this messageList if you're coming from the tutorial,
    // it was used only for my personal debugging
    var messagesList = mutableListOf<Mensaje>()

    private lateinit var adapter: MensajeAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensaje)

        recyclerView()

        clickEvents()
        val bundle = intent.extras
        var nombrePersona = bundle?.getString("nombre").toString()

        adapter.nombrePersona = nombrePersona
        customBotMessage("Hola! Soy ${nombrePersona}, me da mucho gusto hablar contigo")
    }

    private fun clickEvents() {

        //Send a message
        Enviar.setOnClickListener {
            sendMessage()
        }

        //Scroll back to correct position when user clicks on text view
        et_message.setOnClickListener {
            GlobalScope.launch {
                delay(100)

                withContext(Dispatchers.Main) {
                    rv_messages.scrollToPosition(adapter.itemCount - 1)

                }
            }
        }
    }

    private fun recyclerView() {
        adapter = MensajeAdapter()
        rv_messages.adapter = adapter
        rv_messages.layoutManager = LinearLayoutManager(applicationContext)

    }

    override fun onStart() {
        super.onStart()
        //In case there are messages, scroll to bottom when re-opening app
        GlobalScope.launch {
            delay(100)
            withContext(Dispatchers.Main) {
                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }

    private fun sendMessage() {
        val message = et_message.text.toString()
        val timeStamp = Time.timeStamp()

        if (message.isNotEmpty()) {
            //Adds it to our local list
            messagesList.add(Mensaje(message, SEND_ID, timeStamp))
            et_message.setText("")

            adapter.insertarMensaje(Mensaje(message, SEND_ID, timeStamp))
            rv_messages.scrollToPosition(adapter.itemCount - 1)

            botResponse(message)
        }
    }

    private fun botResponse(message: String) {
        val timeStamp = Time.timeStamp()

        GlobalScope.launch {
            //Fake response delay
            delay(1000)

            withContext(Dispatchers.Main) {
                //Gets the response
                val response = BotResponse.basicResponses(message)

                //Adds it to our local list
                messagesList.add(Mensaje(response, RECEIVE_ID, timeStamp))

                //Inserts our message into the adapter
                adapter.insertarMensaje(Mensaje(response, RECEIVE_ID, timeStamp))

                //Scrolls us to the position of the latest message
                rv_messages.scrollToPosition(adapter.itemCount - 1)

                //Starts Google
                when (response) {
                    OPEN_GOOGLE -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        site.data = Uri.parse("https://www.google.com/")
                        startActivity(site)
                    }
                    OPEN_SEARCH -> {
                        val site = Intent(Intent.ACTION_VIEW)
                        val searchTerm: String? = message.substringAfterLast("search")
                        site.data = Uri.parse("https://www.google.com/search?&q=$searchTerm")
                        startActivity(site)
                    }

                }
            }
        }
    }

    private fun customBotMessage(message: String) {

        GlobalScope.launch {
            delay(1000)
            withContext(Dispatchers.Main) {
                val timeStamp = Time.timeStamp()
                messagesList.add(Mensaje(message, RECEIVE_ID, timeStamp))
                adapter.insertarMensaje(Mensaje(message, RECEIVE_ID, timeStamp))

                rv_messages.scrollToPosition(adapter.itemCount - 1)
            }
        }
    }
}