package mohamad.ammar.abu.kalam.loliate.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Category
import mohamad.ammar.abu.kalam.loliate.R
import mohamad.ammar.abu.kalam.loliate.helpers.IntentHelper
import mohamad.ammar.abu.kalam.loliate.viewholder.CategoryViewHolder

class CategoryAdapter(var context: Context,
                      var categories:List<Category>): RecyclerView.Adapter<CategoryViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding: ViewDataBinding = DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.category_item, parent, false
        )
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categories[position])
        holder.itemView.setOnClickListener {
            if(categories[position].isLeaf)
                IntentHelper.startListProductActivity(context, categories[position].id)
            else
                IntentHelper.startCategoryActivity(context, categories[position].id)
        }
    }

    override fun getItemCount(): Int {
        return categories.size
    }
}