package mohamad.ammar.abu.kalam.loliate.activities

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import mohamad.ammar.abu.kalam.apipresentationlibrary.repositories.LoginRepository
import mohamad.ammar.abu.kalam.loliate.databinding.ActivitySplashBinding
import mohamad.ammar.abu.kalam.loliate.helpers.IntentHelper


class SplashActivity : AppCompatActivity() {

    private lateinit var binding:ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        Handler(Looper.getMainLooper()).postDelayed({
            val login = LoginRepository(this@SplashActivity).getLoginResponse()
            if (login!=null) {
                IntentHelper.startCategoryActivity(this@SplashActivity)
            } else {
                IntentHelper.startLoginActivity(this@SplashActivity)
            }
        }, 3000)

    }


}