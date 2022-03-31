package mohamad.ammar.abu.kalam.loliate.viewholder

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Product
import mohamad.ammar.abu.kalam.loliate.BR

class ProductViewHolder(private val binding: ViewDataBinding) :RecyclerView.ViewHolder(binding.root){
    fun bind(product: Product) {
        binding.setVariable(BR.product,product)
        binding.executePendingBindings()
    }

}
