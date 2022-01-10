package com.example.examenprimerbimestre

import java.time.LocalDate
import java.util.*

class BBaseDatosMemoria {
    companion object{
        val arregloBEspecie = arrayListOf<BEspecie>()
        val arregloBRaza = arrayListOf<BRaza>()
        init {
            arregloBEspecie
                .add(
                    BEspecie("Mamiferos", "Pelos", true, 12.21,4381)
                )
            arregloBEspecie
                .add(
                    BEspecie("Aves", "Plumas", false, 11.82, 9271)
                )
            arregloBEspecie
                .add(
                    BEspecie("Reptiles", "Escamas", false, 8.76, 8238)
                )
            arregloBEspecie
                .add(
                    BEspecie("Peces", "Escanas", false, 9.62, 5855)
                )
            arregloBRaza
                .add(
                    BRaza("Perro", "Canis familiaris", "Alemania", 13, true, "Mamiferos")
                )
            arregloBRaza
                .add(
                    BRaza("Peces payaso", "Amphiprioninae", "Índico, el mar Rojo y el Pacífico occidental", 15, false, "Peces")
                )
        }
    }
}