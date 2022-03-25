package mohamad.ammar.abu.kalam.apipresentationlibrary.di.ui

import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.User
import mohamad.ammar.abu.kalam.apipresentationlibrary.request.LoginRequest
import mohamad.ammar.abu.kalam.apipresentationlibrary.responses.LoginResponse

class UserContract {

    interface Presenter : BaseContract.Presenter<View> {
        fun login(loginRequest: LoginRequest)
        fun loadProfile()
    }

    interface View : BaseContract.View {
        fun onLoginSuccessfully(loginResponse: LoginResponse) {}
        fun onLoginFailed() {}
        fun onProfileLoadedSuccessfully(user: User) {}
        fun onProfileLoadingFailed() {}
    }
}