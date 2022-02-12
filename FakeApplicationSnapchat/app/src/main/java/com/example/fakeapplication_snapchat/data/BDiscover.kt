package com.example.fakeapplication_snapchat.data

import android.os.Parcel
import android.os.Parcelable
import com.example.fakeapplication_snapchat.R

/*
class BDiscover(
    private val nombre: String?,
    private val artista: String?,
    private val imagen: Int
    ):Parcelable{
    constructor(parcel: Parcel) : this(

        */
class BDiscover(
    val nombre: String?,
    val descripcion: String?,
    val imagen: Int
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeInt(imagen)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BDiscover> {
        override fun createFromParcel(parcel: Parcel): BDiscover {
            return BDiscover(parcel)
        }

        override fun newArray(size: Int): Array<BDiscover?> {
            return arrayOfNulls(size)
        }
        var data = ArrayList<BVideos>()
            get() = arrayListOf<BVideos>(
                BVideos("Adrian","#video #humor", R.drawable.ic_person_1),
                BVideos("Maria","#tendencia #aplicaciones #moviles", R.drawable.ic_person_2)
            )
    }
}