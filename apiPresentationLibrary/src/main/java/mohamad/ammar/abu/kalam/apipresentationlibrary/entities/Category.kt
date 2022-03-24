package mohamad.ammar.abu.kalam.apipresentationlibrary.entities

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Category() : BaseBindEntity(), Parcelable {

    @SerializedName("id")
    var id:Int=0

    @SerializedName("name")
    var name:String=""

    @SerializedName("nameAr")
    var nameAr:String=""

    @SerializedName("parentID")
    var parentID:Int?=null

    @SerializedName("image")
    var image:String=""


    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        name = parcel.readString()!!
        nameAr = parcel.readString()!!
        parentID = parcel.readInt()
        image = parcel.readString()!!
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(nameAr)
        if(parentID!=null)
            parcel.writeInt(parentID!!)
        parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Category> {
        override fun createFromParcel(parcel: Parcel): Category {
            return Category(parcel)
        }

        override fun newArray(size: Int): Array<Category?> {
            return arrayOfNulls(size)
        }
    }
}