package mohamad.ammar.abu.kalam.loliate.activities

import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import mohamad.ammar.abu.kalam.apipresentationlibrary.di.dialogs.ProgressDialog
import mohamad.ammar.abu.kalam.apipresentationlibrary.di.ui.ProductContract
import mohamad.ammar.abu.kalam.apipresentationlibrary.di.ui.ProductPresenter
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Product
import mohamad.ammar.abu.kalam.loliate.R
import mohamad.ammar.abu.kalam.loliate.adapters.CategoryAdapter
import mohamad.ammar.abu.kalam.loliate.adapters.ProductAdapter
import mohamad.ammar.abu.kalam.loliate.databinding.ActivityProductsBinding
import javax.inject.Inject

@AndroidEntryPoint
class ProductsActivity : BaseActivity(),ProductContract.View {
    lateinit var binding : ActivityProductsBinding
    lateinit var progressDialog : ProgressDialog
    @Inject
    lateinit var presenter : ProductPresenter
    var categoryId : Int=0

    private fun getExtra() {
        if(intent.extras?.getInt("categoryId",-1)!=-1)
            categoryId=intent.extras?.getInt("categoryId")!!
    }

    private fun intiActions() {
        presenter.attachView(this)
        presenter.getProducts(categoryId)
    }

    override fun onBaseCreate(savedInstanceState: Bundle?) {
        binding = ActivityProductsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        progressDialog = ProgressDialog.newInstance()
        presenter.attachView(this)
        getExtra()
        intiActions()
        toolbar= binding.toolbar.toolbar
        initToolBar()
    }

    private fun initToolBar() {
        setSupportActionBar(toolbar)
        toolbar?.setNavigationOnClickListener {
            onBackPressed()
        }
    }

    override fun onRetrievingProductsSuccessfully(products:MutableList<Product>) {
        binding.productsList.adapter= ProductAdapter(this,products)
        binding.productsList.layoutManager = LinearLayoutManager(this)
    }
    override fun onRetrievingProductsFailed() =
        Toast.makeText(this,getString(R.string.failed),Toast.LENGTH_LONG).show()

}