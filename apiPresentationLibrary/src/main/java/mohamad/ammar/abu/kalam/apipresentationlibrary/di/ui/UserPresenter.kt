package mohamad.ammar.abu.kalam.apipresentationlibrary.di.ui

import androidx.fragment.app.FragmentActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import mohamad.ammar.abu.kalam.apipresentationlibrary.apiService.ApiServer
import mohamad.ammar.abu.kalam.apipresentationlibrary.request.LoginRequest
import javax.inject.Inject

class UserPresenter @Inject constructor(val activity: FragmentActivity) : UserContract.Presenter {

    private lateinit var view: UserContract.View

    override fun subscribe() {

    }

    override fun unSubscribe() {

    }

    override fun attachView(view: UserContract.View) {
        this.view = view
    }

    override fun login(loginRequest: LoginRequest) {
        view.showProgress(true)
        val observable = ApiServer(activity).apiInterfaces.login(loginRequest)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    view.showProgress(false)
                    if (response.success) {
                        if (response.data != null) {
                            view.onLoginSuccessfully(response.data!!)
                        } else {
                            view.onLoginFailed()
                        }
                    } else {
                        view.showInternalServerError(true)
                    }
                }, {
                    view.showProgress(false)
                    view.showLoadErrorMessage(true)
                })
    }

    override fun loadProfile() {
        view.showProgress(true)
        val observable = ApiServer(activity).apiInterfaces.getUser()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ response ->
                    view.showProgress(false)
                    if (response.success) {
                        if (response.data != null) {
                            view.onProfileLoadedSuccessfully(response.data!!)
                        } else {
                            view.onProfileLoadingFailed()
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