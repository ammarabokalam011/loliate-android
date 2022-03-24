package mohamad.ammar.abu.kalam.apipresentationlibrary.entities

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class User() : BaseBindEntity(), Parcelable {

    @SerializedName("id")
    var id:Int=0

    @SerializedName("name")
    var name:String=""

    @SerializedName("email")
    var email:String=""

    @SerializedName("password")
    var password:String=""


    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        name = parcel.readString()!!
        email = parcel.readString()!!
        password = parcel.readString()!!
    }

    constructor(id: Int, name: String, email: String, password: String) : this() {
        this.id = id
        this.name = name
        this.email = email
        this.password = password
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(email)
        parcel.writeString(password)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}