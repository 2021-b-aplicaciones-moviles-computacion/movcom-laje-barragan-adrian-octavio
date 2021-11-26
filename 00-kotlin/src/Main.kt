import java.util.*
fun main(): Double {
        println("Hola mundo");//no es requerido, pero no es necesario
        //Tipo nombre = valor
        //int edad = 12;

        //Tipos de variable
        //Inmtutable (val)
        val inmutable: String = "Adrian"
        //inmutable = "Octavio" //x

        //MUTABLE
        var mutable: String = "Octavio"
        mutable = "Adrian"

        //val>var

        // val > var

        // Sintaxis y Duck Typing

        val ejemploVariable = "Nombre"
        var edadEjemplo: Int = 12
        // edadEjemplo = 14.2

        // Tipos de variables JAVA

        val nombre: String = "Adrian Laje"
        val sueldo: Double = 1.2
        val estadoCivil: Char = 'S'
        val fechaNacimiento: Date = Date()

        //Condicionlaes
        if (true){
                //Verdadero
        }else{
                //Falso
        }
        //switch Estado -> S -> C ::::
        val estadoCivilWhen:String = "S"

        when (estadoCivilWhen){
                ("S") -> {
                        println("Acecarse")
                }
                "C" -> {
                        println("Alejarse")
                }
                "UN" -> println("Hablar")
                else -> println("No reconocido")
        }
        //imprimirNombre("Adrian")
        //calcularSueldo(100,14.00, 25.00)
        calcularSueldo(100.00,14.00, 25.00)
        //named Parameters
        calcularSueldo(
                bonoEspecial = 15.00,
                //tasa = 12.00,
                sueldo= 150.00,
        )
        calcularSueldo(
                bonoEspecial = 14.00,
                tasa = 30.00,
                sueldo= 1000.00,
        )
        //Tipos de Arreglos
        //Arreglo Estático
        val arregloEstatico: Array<Int> = arrayOf(1,2,3)
        println(arregloEstatico)

        //Arreglo Dinámico
        val arregloDinamico: ArrayList<Int> = arrayListOf(1,2,3,4,5,6,7,8,9,10)
        println(arregloDinamico)
        arregloDinamico.add(11)
        arregloDinamico.add(12)
        println(arregloDinamico)

        //OPERADORES -> Sirven para los arreglos estáticos y dinámicos

        //FOR EACH -> UNIT
        //Iterar un arreglo

        val respuestaForEach: Unit = arregloDinamico
                .forEach{ valorActual: Int ->
                        println("Valor actual: ${valorActual}")
        }
        arregloDinamico
                .forEachIndexed(){ indice: Int, valorActual: Int ->
                        println("valor ${valorActual} Indice ${indice}")
                }
        println(respuestaForEach)

        // MAP -> Muta el arreglo (Cambia el arreglo)
        // 1) Enviemos el nuevo valor de la iteracion
        // 2) Nos devuelve es un NUEVO ARREGLO con los valores modificados

        val respuestaMap: List<Double> = arregloDinamico
                .map { valorActual: Int ->
                        return@map valorActual.toDouble() + 100.00
                }

        println(respuestaMap)

        val respuestaMapDos = arregloDinamico.map { it + 15 }
//        .map { valorActual: Int ->
//            return@map valorActual + 15
//        }

        println(respuestaMapDos)

}

fun imprimirNombre(nombre: String): Unit{//Unit es el void, y es opcional
        println("Nombre: ${nombre}")
}

fun calcularSueldo(
        sueldo: Double, //Reqerido
        tasa: Double = 12.00, //Opcional (Defecto)
        bonoEspecial: Double? = null, //Opcional (Null) ->nulleable
): Double{
        //String -> String?
        //Int -> Int?
        //Date -> Date?
        if(bonoEspecial == null){
                return sueldo * ( 100 / tasa)
        }else{
                return sueldo * (100/ tasa) + bonoEspecial
        }
}