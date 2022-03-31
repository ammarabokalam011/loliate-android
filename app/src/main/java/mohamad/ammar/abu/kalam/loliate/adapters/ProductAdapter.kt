package mohamad.ammar.abu.kalam.loliate.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Product
import mohamad.ammar.abu.kalam.loliate.R
import mohamad.ammar.abu.kalam.loliate.helpers.IntentHelper
import mohamad.ammar.abu.kalam.loliate.viewholder.ProductViewHolder

class ProductAdapter(var context: Context,var products:List<Product>) :RecyclerView.Adapter<ProductViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.product_item, parent, false
        )
        return ProductViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(products[position])
        holder.itemView.setOnClickListener {
            IntentHelper.startProductDetailActivity(context, products[position].id)
        }
    }

    override fun getItemCount(): Int {
        return products.size
    }
}
