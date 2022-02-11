package com.example.fakeapplication_snapchat.data

import android.os.Parcel
import android.os.Parcelable
import com.example.fakeapplication_snapchat.R

class BAmigosChat (
    val nombre: String?,
    val username: String?,
    val imagen: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readInt()
    ) {
    }

    override fun toString(): String {
        return "${nombre} ${username}"
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(username)
        parcel.writeInt(imagen)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<BAmigosChat> {
        override fun createFromParcel(parcel: Parcel): BAmigosChat {
            return BAmigosChat(parcel)
        }

        override fun newArray(size: Int): Array<BAmigosChat?> {
            return arrayOfNulls(size)
        }

        var data = ArrayList<BAmigosChat>()
            get() = arrayListOf<BAmigosChat>(
                BAmigosChat("Adrian","adrianrd7", R.drawable.ic_person_1),
                BAmigosChat("Maria","mary", R.drawable.ic_person_2)
            )

    }
}