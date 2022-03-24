package mohamad.ammar.abu.kalam.loliate.activities

import android.os.Bundle
import android.os.Handler
import mohamad.ammar.abu.kalam.apipresentationlibrary.repositories.LoginRepository
import mohamad.ammar.abu.kalam.loliate.BuildConfig
import mohamad.ammar.abu.kalam.loliate.databinding.ActivitySplashBinding
import mohamad.ammar.abu.kalam.loliate.helpers.IntentHelper

class SplashActivity : BaseActivity() {

    private lateinit var binding:ActivitySplashBinding

    override fun onBaseCreate(savedInstanceState: Bundle?) {
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Handler().postDelayed({
//            val login = LoginRepository(this@SplashActivity).getLoginEntity()
            if (false) {
//                IntentHelper.startMainActivity(this@SplashActivity)
            } else {
                IntentHelper.startLoginActivity(this@SplashActivity)
            }
        }, 3000)

    }

}