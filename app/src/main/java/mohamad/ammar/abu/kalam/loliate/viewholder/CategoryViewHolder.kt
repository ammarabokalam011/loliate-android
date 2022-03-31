package mohamad.ammar.abu.kalam.loliate.viewholder

import android.content.Context
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Category
import mohamad.ammar.abu.kalam.loliate.BR

class CategoryViewHolder(private val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(category: Category) {
        binding.setVariable(BR.category,category)
        binding.executePendingBindings()
    }

}
