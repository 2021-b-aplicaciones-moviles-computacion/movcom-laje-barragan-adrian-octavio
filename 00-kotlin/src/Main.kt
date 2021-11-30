import java.util.*
fun main() {
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

        ///Fliter -> Filtrar el arreglo
//1) Devolver una expresion(True o Flase)

//OR AND
//OR -> ANY (Algunos cumplen)
//AND -> ALL (Todos cumplen)
        val respuestasAny: Boolean = arregloDinamico
                .any{ valorActual: Int ->
                        return@any (valorActual > 5)
                }
        println(respuestasAny)//true
        val respuestasAll: Boolean = arregloDinamico
                .any{ valorActual: Int ->
                        return@any (valorActual > 5)
                }
        println(respuestasAll)//false

//REDUCE -> Valor acumulado
//valor acumulado = 0 (Siempre 0 en lengualje kotlin)
//[1, 2, 3, 4, 5]
//valorIteracion1 = valorEmpieza + 1 = 0 + 1=1 -> Iteracion 1
//valorIteracion2 = valorIteracion1 + 2 = 1 + 2=3 -> Iteracion 2
//valorIteracion3 = valorIteracion2 + 3 = 3 + 3=6 -> Iteracion 3
//valorIteracion4 = valorIteracion3 + 4 = 6 + 4=10 -> Iteracion 4
//valorIteracion5 = valorIteracion4 + 5 = 10 + 5=15 -> Iteracion 5
        val respuestaReduce: Int = arregloDinamico
                .reduce{
                                acumulado: Int, valorActual: Int ->
                        return@reduce (acumulado + valorActual)
                }
        println(respuestaReduce)
        val arrergloDanio = arrayListOf<Int>(12,15,8,10)
        val respuestaReduceFold = arrergloDanio
                .fold(
                        100,{acumulado, valorActualIteraccion ->
                                return@fold acumulado - valorActualIteraccion
                        }
                )
        println(respuestaReduceFold)

        val vidaActual: Double = arregloDinamico
                .map { it * 2.3 }
                .filter { it > 20 }
                .fold (100.00 , {acc, i -> acc -i })
                .also { println(it) }

        println(vidaActual)


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
abstract class NumerosJava{
        protected val numeroUno: Int //Propiedad clase
        private val numeroDos: Int //Propiedad clase

        constructor(
                uno: Int, //parametrosRequerido
                dos: Int//parametrosRequerido
        ){
                numeroUno = uno
                numeroDos = dos
                //this.numeroUno = uno
                //this.numeroDos = dos
                println("Inicializar")

        }
}

abstract class Numeros(
        protected var numeroUno: Int, //Propiedad Clase
        protected var numeroDos: Int, //Propiedad Clase
){
        init { //Bloque inicio del contructor primario
            println("Inicializar")
        }
}


class Suma(
        uno: Int, //Parametro Requerido
        dos: Int,//Parametro Requerido
): Numeros( //Constructor super
        uno,
        dos
){
        init {//Es el bloque de codigo de constructor primari
                this.numeroUno
                this.numeroDos
                //X -> this.uno -> No existen
                //X-> this.dos -> No existen
        }
        //public fun sumar(): Int{
        fun sumar(): Int{
                val total: Int = numeroUno +numeroDos
                return total
        }
}