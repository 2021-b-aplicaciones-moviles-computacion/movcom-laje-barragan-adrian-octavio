package com.example.fakeapplication_snapchat.data

import android.os.Parcel
import android.os.Parcelable
import com.example.fakeapplication_snapchat.R

class BVideos(
    val nombre: String?,
    val descripcion: String?,
    val video: Int
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
        parcel.writeInt(video)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BVideos> {
        override fun createFromParcel(parcel: Parcel): BVideos {
            return BVideos(parcel)
        }

        override fun newArray(size: Int): Array<BVideos?> {
            return arrayOfNulls(size)
        }
        var data = ArrayList<BVideos>()
            get() = arrayListOf<BVideos>(
                BVideos("Adrian","#video", R.drawable.ic_person_1),
                BVideos("Maria","#tendencia", R.drawable.ic_person_2)
            )
    }
}