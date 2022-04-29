package mohamad.ammar.abu.kalam.loliate.activities

import android.os.Bundle
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint
import mohamad.ammar.abu.kalam.apipresentationlibrary.apiService.ApiInfo
import mohamad.ammar.abu.kalam.apipresentationlibrary.di.dialogs.ProgressDialog
import mohamad.ammar.abu.kalam.apipresentationlibrary.di.ui.ProductContract
import mohamad.ammar.abu.kalam.apipresentationlibrary.di.ui.ProductPresenter
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Product
import mohamad.ammar.abu.kalam.loliate.databinding.ActivityProductDetailBinding
import javax.inject.Inject

@AndroidEntryPoint
class ProductDetailActivity : BaseActivity(),ProductContract.View {
    lateinit var binding : ActivityProductDetailBinding
    lateinit var progressDialog : ProgressDialog
    @Inject
    lateinit var presenter : ProductPresenter
    var productId : Int=0

    override fun onBaseCreate(savedInstanceState: Bundle?) {
        binding=ActivityProductDetailBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)
        progressDialog = ProgressDialog.newInstance()
        presenter.attachView(this)
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

    private fun intiActions() {
        if(intent.extras?.getInt("productId",-1)!=-1)
            productId=intent.extras?.getInt("productId")!!
        presenter.getProduct(productId);
    }

    override fun onRetrievingProductSuccessfully(product: Product) {
        super.onRetrievingProductSuccessfully(product)
        binding.code.text =product.code
        binding.description.text =product.description
        binding.specification.text =product.specification
        binding.price.text =product.price.toString()+" ل.س "
        binding.name.text =product.name
        binding.nameAr.text =product.nameAr
        Glide.with(this)
            .load(ApiInfo.baseUrl + "productImages/" + product.image)
            .into(binding.image)

    }

    override fun onRetrievingProductFailed() {
        super.onRetrievingProductFailed()
    }

    override fun onRetrievingProductLoadingFailed() {
        super.onRetrievingProductLoadingFailed()
    }
}