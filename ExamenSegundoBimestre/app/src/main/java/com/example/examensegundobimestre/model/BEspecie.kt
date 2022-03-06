package com.example.examensegundobimestre.model

import android.os.Parcel
import android.os.Parcelable

class BEspecie(
    var nombre: String?,
    var piel: String?,
    var amamantan: Boolean?,
    var porcentajeEcuador: Double?,
    var numeroEspecie: Int
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readValue(Boolean::class.java.classLoader) as? Boolean,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readInt()
    ) {
    }
    override fun toString(): String {
        return "${nombre}\nTipo de piel = ${piel}\n ¿Amamantan? ${amamantan} \n" +
                "Número de $nombre  en el mundo = $numeroEspecie \n$nombre en el Ecuador = ${porcentajeEcuador} %"
    }
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(piel)
        parcel.writeValue(amamantan)
        parcel.writeValue(porcentajeEcuador)
        parcel.writeInt(numeroEspecie)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BEspecie> {
        override fun createFromParcel(parcel: Parcel): BEspecie {
            return BEspecie(parcel)
        }

        override fun newArray(size: Int): Array<BEspecie?> {
            return arrayOfNulls(size)
        }
    }


}
