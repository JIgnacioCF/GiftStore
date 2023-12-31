package mx.tecnm.cdhidalgo.giftstore.DataClass

import android.os.Parcel
import android.os.Parcelable

data class Usuario(
    var correo:String?,
    var nombre:String?,
    var apaterno:String?,
    var amaterno:String?):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(correo)
        parcel.writeString(nombre)
        parcel.writeString(apaterno)
        parcel.writeString(amaterno)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Usuario> {
        override fun createFromParcel(parcel: Parcel): Usuario {
            return Usuario(parcel)
        }

        override fun newArray(size: Int): Array<Usuario?> {
            return arrayOfNulls(size)
        }
    }
}
