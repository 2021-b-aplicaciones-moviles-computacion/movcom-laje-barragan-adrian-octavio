package com.example.fakeapplication_snapchat.data

import android.os.Parcel
import android.os.Parcelable
import com.example.fakeapplication_snapchat.R

class BAmigos (
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

    companion object CREATOR : Parcelable.Creator<BAmigos> {
        override fun createFromParcel(parcel: Parcel): BAmigos {
            return BAmigos(parcel)
        }

        override fun newArray(size: Int): Array<BAmigos?> {
            return arrayOfNulls(size)
        }

        val data
            get() = arrayListOf<BAmigos>(
                BAmigos("Samuel", "samson1", R.drawable.ic_person_3),
                BAmigos("Sophia", "sophie", R.drawable.ic_person_4),
                BAmigos("Aisha", "aii442", R.drawable.ic_person_5),
                BAmigos("Paul", "paul_kiki", R.drawable.ic_person_6),
                BAmigos("Omar", "omarlopez21", R.drawable.ic_person_7),
                BAmigos("Ana", "ana.dtya", R.drawable.ic_person_8),
                BAmigos("Alex", "alexttz", R.drawable.ic_person_9)
            )

    }
}