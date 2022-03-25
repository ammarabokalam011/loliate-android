package mohamad.ammar.abu.kalam.apipresentationlibrary.repositories

import android.content.Context
import com.google.gson.Gson
import mohamad.ammar.abu.kalam.apipresentationlibrary.responses.LoginResponse


class LoginRepository(context: Context) : BasePrefRepository(context) {
    companion object {
        const val LOGIN_TAG = "LOGIN_TAG"
        val LOGIN_RESPONSE_DEFAULT = null
    }

    fun setLoginResponse(loginResponse: LoginResponse) {
        val jSon= Gson().toJson(loginResponse).toString()
        editor.putString(LOGIN_TAG, jSon)
        editor.apply()
    }

    fun getLoginResponse(): LoginResponse? {
        var loginResponse: LoginResponse? = null
        val serialized = preferences.getString(LOGIN_TAG, LOGIN_RESPONSE_DEFAULT)
        if (serialized != null)
            loginResponse = Gson().fromJson(serialized, LoginResponse::class.java)
        return loginResponse
    }

    fun clearLoginEntity() {
        editor.putString(LOGIN_TAG, LOGIN_RESPONSE_DEFAULT)
        editor.apply()
    }

}