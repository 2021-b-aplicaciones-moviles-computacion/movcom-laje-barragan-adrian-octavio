package com.example.fakeapplication_snapchat.utils


import com.example.fakeapplication_snapchat.utils.Constants.OPEN_GOOGLE
import com.example.fakeapplication_snapchat.utils.Constants.OPEN_SEARCH
import java.sql.Date
import java.sql.Timestamp
import java.text.SimpleDateFormat

object BotResponse {

    fun basicResponses(_message: String): String {

        val random = (0..2).random()
        val message =_message.toLowerCase()

        return when {

            //Flips a coin
            message.contains("lanza") && message.contains("moneda") -> {
                val r = (0..1).random()
                val result = if (r == 0) "cara" else "cruz"

                "Lancé una moneda y cayó en $result"
            }

            //Math calculations
            message.contains("solve") -> {
                val equation: String? = message.substringAfterLast("solve")
                return try {
                    val answer = SolveMath.solveMath(equation ?: "0")
                    "$answer"

                } catch (e: Exception) {
                    "Lo siento, no puedo resolver eso."
                }
            }

            //Hello
            message.contains("hola") -> {
                when (random) {
                    0 -> "¡Hola!"
                    1 -> "Siuuuu siu siu siuuu"
                    2 -> "Buen día!"
                    else -> "error" }
            }

            //How are you?
            message.contains("como estas") -> {
                when (random) {
                    0 -> "¡Estoy bien, gracias!"
                    1 -> "Tengo hambre..."
                    2 -> "¡Bastante bueno! ¿Y usted?"
                    else -> "error"
                }
            }

            //What time is it?
            message.contains("time") && message.contains("?")-> {
                val timeStamp = Timestamp(System.currentTimeMillis())
                val sdf = SimpleDateFormat("dd/MM/yyyy HH:mm")
                val date = sdf.format(Date(timeStamp.time))

                date.toString()
            }

            //Open Google
            message.contains("open") && message.contains("google")-> {
                OPEN_GOOGLE
            }

            //Search on the internet
            message.contains("search")-> {
                OPEN_SEARCH
            }

            //When the programme doesn't understand...
            else -> {
                when (random) {
                    0 -> "No entiendo..."
                    1 -> "Intenta preguntarme algo diferente"
                    2 -> "No sé"
                    else -> "error"
                }
            }
        }
    }
}