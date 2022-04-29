package mohamad.ammar.abu.kalam.loliate.helpers

import android.widget.*
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import mohamad.ammar.abu.kalam.apipresentationlibrary.apiService.ApiInfo
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Product

@BindingAdapter("productImage")
fun bindProductImage(imageView: ImageView,image: String) {
    val url = ApiInfo.baseUrl + "productImages/" + image
    val context = imageView.context
    Glide.with(context)
        .load(url)
        .into(imageView)
}

@BindingAdapter("categoryImage")
fun bindCategoryImage(imageView: ImageView,imageUrl:String) {
    val url = ApiInfo.baseUrl + "categoryImages/" + imageUrl
    val context = imageView.context
    Glide.with(context)
        .load(url)
        .into(imageView)
}

@BindingAdapter("productPrice")
fun bindProductPrice(textView: TextView,price: Int) {
    textView.text = price.toString() +"sp"
}
