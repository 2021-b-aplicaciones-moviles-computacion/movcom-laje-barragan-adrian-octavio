package com.example.fakeapplication_snapchat.data

import android.os.Parcel
import android.os.Parcelable
import com.example.fakeapplication_snapchat.R

class BVideos(
    val nombre: String?,
    val descripcion: String?,
    val video: String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeString(video)
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
                BVideos("Adrian","#video #humor", "https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4"),
                BVideos("Maria","#tendencia #aplicaciones #moviles","https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"),
                BVideos("Maria","#tendencia #aplicaciones #moviles","https://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ForBiggerFun.mp4"),
            )
    }
}