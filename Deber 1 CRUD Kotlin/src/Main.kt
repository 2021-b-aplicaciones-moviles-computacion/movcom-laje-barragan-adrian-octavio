import java.util.*
fun main(){

}

abstract class Especie(
    protected var nombreEspecie: String,
    protected var generoEspecie: String,
    protected var numeroEspecie: Int,
    protected var reproducirseEntreSi: Boolean,
    protected var nicho: String,
) {
    init {
        println("Inicializar")
    }


}
class raza(
    nombreRaza: String,
    fechaAparicion: Date,
    regionOrigen: String,
    maximaEsperanzaVida: Int,
    otroNombre: String
):Especie(

){

}