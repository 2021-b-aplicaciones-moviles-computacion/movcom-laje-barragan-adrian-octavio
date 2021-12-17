import java.io.*
import java.util.*
import kotlin.collections.ArrayList


fun main(){
    var especie: Especie
    var raza: Raza
    Especie.actualizarArchivoEspecie()
    Raza.actualizarArchivoRaza()
    var select = 2
    do {
        println("Elige opción:\n" +
                "0. Salir\n" +
                "1. Crear Especie\n" +
                "2. Leer  Especies\n"+
                "3. Eliminar Especie\n" +
                "4. Actualizar Especie\n" +
                "5. Crear  Raza\n" +
                "Ingrese la opción:")
        val selected = readLine()!!.toInt()
        when (selected){
            1 -> {
                especie = Especie("Perro","Canis","Carnivora" , true, 40.0)
                //especie = Especie(cargarString("Nombre de la especie"),cargarString("Otro nombre"),
                //    cargarString("Alimentacion"), cargarBoolean("Reproduccion entre especies"), cargarDouble("El peso maximo en Kilogramos"))
                Especie.crearEspecie(especie)
                Especie.actualizarArchivoEspecie()
            }
            2->{
                Especie.leerEspecies()
            }
            3 ->{
                Especie.leerEspecies()
                println("Ingrese el indice la especie para eliminar:")
                val valor = readLine()!!.toInt()
                Especie.eliminarEspecie(valor)
                Especie.actualizarArchivoEspecie()
            }
            4 ->{
                Especie.leerEspecies()
                println("Ingrese el indice la especie para actualizar:")
                val valor = readLine()!!.toInt()
                Especie.updateEspecie(valor)
                Especie.actualizarArchivoEspecie()
            }
            5->{
                var select1 = 1
                do{
                    println("Elige opción:\n" +
                        "0. Regresar al anterior\n" +
                        "1. Crear Raza\n" +
                        "2. Leer  Raza\n"+
                        "3. Eliminar Raza\n" +
                        "4. Actualizar Raza\n" +
                        "Ingrese la opción:")
                    val selected1 = readLine()!!.toInt()
                    when(selected1){
                        1->{
                            Especie.leerEspecies()
                            println("Ingrese el indice las 1 para crear la raza:")
                            val indice = readLine()!!.toInt()

                            raza = Raza("Perro", Date(1986,0,2) , "Londres", 10, true,
                            Especie.listaEspecie[indice].nombreEspecie,Especie.listaEspecie[indice].otroNombre, Especie.listaEspecie[indice].alimentacion,
                                Especie.listaEspecie[indice].reproducirseEntreSi, Especie.listaEspecie[indice].pesoAproximadoKG)
                            /*raza = Raza ( cargarString("nombre raza"), Date(cargarInt("año"),cargarInt("mes"),cargarInt("dia")) ,cargarString("region de origen") , cargarInt("esperanza de vida")
                            ,cargarBoolean("es domesticado? true/false") , Especie.listaEspecie[indice].nombreEspecie , Especie.listaEspecie[indice].otroNombre , Especie.listaEspecie[indice].alimentacion
                            , Especie.listaEspecie[indice].reproducirseEntreSi , Especie.listaEspecie[indice].pesoAproximadoKG)*/
                            Raza.crearRaza(raza)
                            Raza.actualizarArchivoRaza()
                        }
                        2->{
                            Raza.leerRazas()
                        }
                        3 ->{
                            Raza.leerRazas()
                            println("Ingrese el indice la raza para eliminar:")
                            val valor = readLine()!!.toInt()
                            Raza.eliminarRazas(valor)
                            Raza.actualizarArchivoRaza()
                        }
                        4 ->{
                            Raza.leerRazas()
                            println("Ingrese el indice la raza para actualizar:")
                            val valor = readLine()!!.toInt()
                            Raza.updateRazas(valor)
                            Raza.actualizarArchivoRaza()
                        }
                        0->{
                            println("¿Deseas regresar al otro nodo? S/N ")
                            println("Digita 1 =  Si Digita 2 = No ")
                            val seleccionado = readLine()!!.toInt()
                            if ( seleccionado == 1)
                                select1 = 0
                        }
                        else ->{
                            println("Número no reconocido")
                        }
                    }
                }while(select1 != 0)
            }
            0->{
                println("¿Deseas salir? S/N ")
                println("Digita 1 =  Si Digita 2 = No ")
                val seleccionado = readLine()!!.toInt()
                if ( seleccionado == 1)
                    select = 0
            }
            else ->{
                println("Número no reconocido")
            }

        }


    }while (select != 0)

}


fun cargarString(titulo: String):  String{
    print("Ingrese  ${titulo}:")
    val valor = readLine()!!.toString()
    return valor
}
fun cargarInt(titulo: String):  Int{
    print("Ingrese  ${titulo}:")
    val valor = readLine()!!.toInt()
    return valor
}
fun cargarDouble(titulo: String):  Double{
    print("Ingrese  ${titulo}:")
    val valor = readLine()!!.toDouble()
    return valor
}
fun cargarBoolean(titulo: String):  Boolean{
    print("Ingrese  ${titulo}:")
    val valor = readLine()!!.toBoolean()
    return valor
}

open class Especie(
    var nombreEspecie: String,
    var  otroNombre: String,
    var  alimentacion: String,
    var  reproducirseEntreSi: Boolean,
    var  pesoAproximadoKG: Double
) {

    companion object {
        val listaEspecie: ArrayList<Especie> = arrayListOf()
        fun crearEspecie(especieNueva:Especie){
            listaEspecie.add(especieNueva)
            println("Especie agregada!!")
        }
        fun leerEspecies(){
            listaEspecie
                .forEachIndexed() { index: Int, valorActual: Especie ->
                    println("Especie[${index}]: [ ${valorActual.nombreEspecie} , ${valorActual.otroNombre} " +
                            ", ${valorActual.alimentacion}, ${valorActual.reproducirseEntreSi}" +
                            ", ${valorActual.pesoAproximadoKG}]")
                }
            if(listaEspecie.size == 0)
                println("Esta vacia!!")
        }
        fun eliminarEspecie(index: Int){
            if (listaEspecie.size > 0){
                listaEspecie.removeAt(index)
                println("Eliminado!!")
            }
        }
        fun updateEspecie(i: Int){
            listaEspecie.mapIndexed { index, especie ->
                if(index == i){
                    especie.nombreEspecie = cargarString("Nombre de la especie")
                    especie.otroNombre = cargarString("Otro nombre")
                    especie.alimentacion = cargarString("Alimentacion")
                    especie.reproducirseEntreSi = cargarBoolean("Reproduccion entre especies")
                    especie.pesoAproximadoKG = cargarDouble("El peso maximo en Kilogramos")
                }
                return@mapIndexed especie
            }
        }
        fun actualizarArchivoEspecie() {
            val ruta = "src/especie.txt"
            try {
                FileWriter(ruta, false).use { fw ->
                    BufferedWriter(fw).use { bw ->
                        PrintWriter(bw).use { out ->
                            listaEspecie.forEachIndexed() { index, valorActual ->  out.print("Especie[${index}]: [ ${valorActual.nombreEspecie} , ${valorActual.otroNombre} " +
                                    ", ${valorActual.alimentacion}, ${valorActual.reproducirseEntreSi}" +
                                    ", ${valorActual.pesoAproximadoKG}]") }
                        }
                    }
                }
            } catch (e: IOException) {
                //exception handling left as an exercise for the reader
            }
        }
    }


}
class Raza(
    var nombreRaza: String,
    var fechaCreacion: Date,
    var regionOrigen: String,
    var maximaEsperanzaVida: Int,
    var domesticado: Boolean, nombreEspecie: String, otroNombre: String, alimentacion: String, reproducirseEntreSi: Boolean,
    pesoAproximadoKG: Double,
):Especie(nombreEspecie, otroNombre, alimentacion, reproducirseEntreSi, pesoAproximadoKG){
    companion object {
        val listaRaza: ArrayList<Raza> = arrayListOf()
        fun crearRaza(razaNueva:Raza){
            listaRaza.add(razaNueva)
            println("Raza agregada!!")
        }
        fun leerRazas(){
            listaRaza
                .forEachIndexed() { index: Int, valorActual: Raza ->
                    println("Raza[${index}]: [ ${valorActual.nombreRaza} , ${valorActual.fechaCreacion} " +
                            ", ${valorActual.regionOrigen}, ${valorActual.maximaEsperanzaVida}" +
                            ", ${valorActual.domesticado}] <- Especie { ${valorActual.nombreEspecie} , ${valorActual.otroNombre} " +
                            "${valorActual.alimentacion}, ${valorActual.reproducirseEntreSi}" +
                            ", ${valorActual.pesoAproximadoKG}} ")
                }
            if(listaRaza.size == 0)
                println("Esta vacia!!")
        }
        fun eliminarRazas(index: Int){
            if (listaEspecie.size > 0){
                listaRaza.removeAt(index)
                println("Eliminado!!")
            }
        }
        fun updateRazas(i: Int){
            listaRaza.mapIndexed { index, raza ->
                if(index == i){
                    Especie.leerEspecies()
                    println("Ingrese el indice las espcies para crear la raza:")
                    val indice = readLine()!!.toInt()
                    raza.nombreRaza = cargarString("nombre raza")
                    raza.fechaCreacion = Date(cargarInt("año"),cargarInt("mes"),cargarInt("dia"))
                    raza.regionOrigen = cargarString("region de origen")
                    raza.maximaEsperanzaVida = cargarInt("esperanza de vida")
                    raza.domesticado = cargarBoolean("es domesticado? true/false")
                    raza.nombreEspecie = Especie.listaEspecie[indice].nombreEspecie
                    raza.otroNombre = Especie.listaEspecie[indice].otroNombre
                    raza.alimentacion = Especie.listaEspecie[indice].alimentacion
                    raza.reproducirseEntreSi = Especie.listaEspecie[indice].reproducirseEntreSi
                    raza.pesoAproximadoKG = Especie.listaEspecie[indice].pesoAproximadoKG
                }
                return@mapIndexed raza
            }
        }
        fun actualizarArchivoRaza() {
            val ruta = "src/raza.txt"
            try {
                FileWriter(ruta, false).use { fw ->
                    BufferedWriter(fw).use { bw ->
                        PrintWriter(bw).use { out ->
                            listaRaza.forEachIndexed() { index, valorActual ->  out.print("Raza[${index}]: [ ${valorActual.nombreRaza} , ${valorActual.fechaCreacion} " +
                                    ", ${valorActual.regionOrigen}, ${valorActual.maximaEsperanzaVida}" +
                                    ", ${valorActual.domesticado}] <- Especie { ${valorActual.nombreEspecie} , ${valorActual.otroNombre} " +
                                    "${valorActual.alimentacion}, ${valorActual.reproducirseEntreSi}" +
                                    ", ${valorActual.pesoAproximadoKG}} ") }
                        }
                    }
                }
            } catch (e: IOException) {
                //exception handling left as an exercise for the reader
            }
        }
    }

}