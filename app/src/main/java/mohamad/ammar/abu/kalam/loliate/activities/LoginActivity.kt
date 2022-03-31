package mohamad.ammar.abu.kalam.loliate.activities

import android.os.Bundle
import android.widget.Toast
import dagger.hilt.android.AndroidEntryPoint
import mohamad.ammar.abu.kalam.apipresentationlibrary.di.dialogs.ProgressDialog
import mohamad.ammar.abu.kalam.apipresentationlibrary.di.ui.UserContract
import mohamad.ammar.abu.kalam.apipresentationlibrary.di.ui.UserPresenter
import mohamad.ammar.abu.kalam.apipresentationlibrary.repositories.LoginRepository
import mohamad.ammar.abu.kalam.apipresentationlibrary.request.LoginRequest
import mohamad.ammar.abu.kalam.apipresentationlibrary.responses.LoginResponse
import mohamad.ammar.abu.kalam.loliate.R
import mohamad.ammar.abu.kalam.loliate.databinding.ActivityLoginBinding
import mohamad.ammar.abu.kalam.loliate.helpers.IntentHelper
import javax.inject.Inject

@AndroidEntryPoint
class LoginActivity : BaseActivity(),UserContract.View  {

    private lateinit var progressDialog: ProgressDialog
//    private lateinit var loginViewModel: LoginViewModel
    @Inject
    lateinit var presenter: UserPresenter
    private lateinit var binding: ActivityLoginBinding


    override fun onBaseCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        progressDialog = ProgressDialog.newInstance()
        presenter.attachView(this)
        intiActions()
    }

    private fun intiActions() {
        binding.loginBtn.setOnClickListener {
            presenter.login(
                LoginRequest(
                    binding.phoneEditText.text.toString()
                    ,binding.passwordEditText.text.toString())
            )
        }
    }

    override fun showProgress(show: Boolean) {
        if (show) {
            progressDialog.showDialog(supportFragmentManager)
        } else {
            ProgressDialog.closeDialog(supportFragmentManager)
        }
    }

    override fun showLoadErrorMessage(visible: Boolean) {
        if (visible)
            Toast.makeText(baseContext, R.string.pleaseCheckConnection, Toast.LENGTH_LONG).show()
    }

     override fun showInternalServerError(visible: Boolean) {
        if (visible)
            Toast.makeText(baseContext, R.string.unExpectedErrorHappened, Toast.LENGTH_LONG).show()
    }

    override fun onLoginSuccessfully(loginResponse: LoginResponse) {
        LoginRepository(this).setLoginResponse(loginResponse)
        IntentHelper.startCategoryActivity(this)
    }

    override fun onLoginFailed() {
        Toast.makeText(baseContext, R.string.userNameOrPasswordIncorrect, Toast.LENGTH_LONG).show()
        binding.phoneEditText.requestFocus()
    }

}
