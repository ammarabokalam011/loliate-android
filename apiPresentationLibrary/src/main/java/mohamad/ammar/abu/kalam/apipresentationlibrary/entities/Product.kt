package mohamad.ammar.abu.kalam.apipresentationlibrary.entities

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

class Product() : BaseBindEntity(), Parcelable {

    @SerializedName("id")
    var id:Int=0

    @SerializedName("name")
    var name:String=""

    @SerializedName("nameAr")
    var nameAr:String=""

    @SerializedName("categoryID")
    var categoryID:Int=0

    @SerializedName("description")
    var description:String=""

    @SerializedName("specification")
    var specification:String=""

    @SerializedName("price")
    var price:Int=0

    @SerializedName("quantity")
    var quantity:Int=0

    @SerializedName("available")
    var available:Boolean=true

    @SerializedName("image")
    var image:String=""


    constructor(parcel: Parcel) : this() {
        id = parcel.readInt()
        name = parcel.readString()!!
        nameAr = parcel.readString()!!
        categoryID = parcel.readInt()
        image = parcel.readString()!!
        description = parcel.readString()!!
        specification = parcel.readString()!!
        price = parcel.readInt()
        quantity = parcel.readInt()
        available = parcel.readString().toBoolean()
    }


    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeString(nameAr)
        parcel.writeInt(categoryID)
        parcel.writeString(image)
        parcel.writeString(description)
        parcel.writeString(specification)
        parcel.writeInt(price)
        parcel.writeInt(quantity)
        parcel.writeString(available.toString())
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Product> {
        override fun createFromParcel(parcel: Parcel): Product {
            return Product(parcel)
        }

        override fun newArray(size: Int): Array<Product?> {
            return arrayOfNulls(size)
        }
    }
}