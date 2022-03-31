package mohamad.ammar.abu.kalam.apipresentationlibrary.di.ui

import androidx.fragment.app.FragmentActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import mohamad.ammar.abu.kalam.apipresentationlibrary.apiService.ApiServer
import mohamad.ammar.abu.kalam.apipresentationlibrary.request.LoginRequest
import javax.inject.Inject

class ProductPresenter @Inject constructor(val activity: FragmentActivity) :
    ProductContract.Presenter {

    private lateinit var view: ProductContract.View
    override fun getProducts(categoryId: Int) {
        view.showProgress(true)
        val observable = ApiServer(activity).apiInterfaces.getProductsList(categoryId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                view.showProgress(false)
                if (response.success) {
                    if (response.data != null) {
                        view.onRetrievingProductsSuccessfully(response.data!!)
                    } else {
                        view.onRetrievingProductsFailed()
                    }
                } else {
                    view.showInternalServerError(true)
                }
            }, {
                view.showProgress(false)
                view.showLoadErrorMessage(true)
            })
    }

    override fun getProduct(productId: Int) {
        view.showProgress(true)
        val observable = ApiServer(activity).apiInterfaces.getProduct(productId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                view.showProgress(false)
                if (response.success) {
                    if (response.data != null) {
                        view.onRetrievingProductSuccessfully(response.data!!)
                    } else {
                        view.onRetrievingProductsFailed()
                    }
                } else {
                    view.showInternalServerError(true)
                }
            }, {
                view.showProgress(false)
                view.showLoadErrorMessage(true)
            })
    }

    override fun subscribe() {

    }

    override fun unSubscribe() {

    }

    override fun attachView(view: ProductContract.View) {
        this.view = view
    }
}