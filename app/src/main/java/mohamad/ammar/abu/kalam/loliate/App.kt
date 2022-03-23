package mohamad.ammar.abu.kalam.loliate

import androidx.multidex.MultiDexApplication
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : MultiDexApplication() {

    companion object {

        lateinit var app: App
    }

    override fun onCreate() {
        super.onCreate()
        app=this
    }

}