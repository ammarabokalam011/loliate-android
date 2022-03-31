package mohamad.ammar.abu.kalam.apipresentationlibrary.di.ui

import androidx.fragment.app.FragmentActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import mohamad.ammar.abu.kalam.apipresentationlibrary.apiService.ApiServer
import mohamad.ammar.abu.kalam.apipresentationlibrary.request.LoginRequest
import javax.inject.Inject

class CategoryPresenter @Inject constructor(val activity: FragmentActivity) :
    CategoryContract.Presenter {

    private lateinit var view: CategoryContract.View

    override fun subscribe() {

    }

    override fun unSubscribe() {

    }

    override fun attachView(view: CategoryContract.View) {
        this.view = view
    }


    override fun getCategories(id: Int?) {
        view.showProgress(true)
        val observable = ApiServer(activity).apiInterfaces.getCategoriesList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                view.showProgress(false)
                if (response.success) {
                    if (response.data != null) {
                        view.onRetrievingCategoriesSuccessfully(response.data!!)
                    } else {
                        view.onRetrievingCategoriesFailed()
                    }
                } else {
                    view.showInternalServerError(true)
                }
            }, {
                view.showProgress(false)
                view.showLoadErrorMessage(true)
            })
    }


}