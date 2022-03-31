package mohamad.ammar.abu.kalam.loliate.activities

import android.os.Bundle
import android.view.KeyEvent
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import mohamad.ammar.abu.kalam.apipresentationlibrary.di.dialogs.ProgressDialog
import mohamad.ammar.abu.kalam.apipresentationlibrary.di.ui.CategoryContract
import mohamad.ammar.abu.kalam.apipresentationlibrary.di.ui.CategoryPresenter
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Category
import mohamad.ammar.abu.kalam.loliate.adapters.CategoryAdapter
import mohamad.ammar.abu.kalam.loliate.databinding.ActivityCategoryBinding
import javax.inject.Inject

@AndroidEntryPoint
class CategoryActivity : BaseActivity() ,CategoryContract.View{
    private lateinit var binding : ActivityCategoryBinding
    lateinit var progressDialog : ProgressDialog
    @Inject
    lateinit var presenter : CategoryPresenter
    var categoryId : Int?= null
    override fun onBaseCreate(savedInstanceState: Bundle?) {
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        progressDialog = ProgressDialog.newInstance()
        presenter.attachView(this)
        intiActions()
    }

    private fun intiActions() {
        if(intent.extras?.getInt("parentId",-1)!=-1)
            categoryId=intent.extras?.getInt("parentId")
        presenter.getCategories(categoryId);
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressDialog.showDialog(supportFragmentManager)
        } else {
            ProgressDialog.closeDialog(supportFragmentManager)
        }
    }

    override fun onRetrievingCategoriesSuccessfully(categories: MutableList<Category>) {
        binding.categoriesList.adapter= CategoryAdapter(this,categories.filter { it.parentID==categoryId })
        binding.categoriesList.layoutManager = GridLayoutManager(this,2)
    }


}