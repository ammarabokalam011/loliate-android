package mohamad.ammar.abu.kalam.loliate.activities

import android.os.Bundle
import android.os.Handler
import mohamad.ammar.abu.kalam.apipresentationlibrary.repositories.LoginRepository
import mohamad.ammar.abu.kalam.loliate.BuildConfig
import mohamad.ammar.abu.kalam.loliate.R
import mohamad.ammar.abu.kalam.loliate.helpers.IntentHelper

class SplashActivity : BaseActivity() {

    override fun onBaseCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_splash)
        Handler().postDelayed({
            val login = LoginRepository(this@SplashActivity).getLoginEntity()
            if (login != null) {
//                IntentHelper.startMainActivity(this@SplashActivity)
            } else {
                IntentHelper.startLoginActivity(this@SplashActivity)
            }
        }, 30)

    }

}