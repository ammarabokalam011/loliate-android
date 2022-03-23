package mohamad.ammar.abu.kalam.loliate.activities

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import mohamad.ammar.abu.kalam.loliate.helpers.LocaleHelper

abstract class BaseActivity : AppCompatActivity() {

    init {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(LocaleHelper.onAttach(newBase, LocaleHelper.getLanguage(newBase)))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        onBaseCreate(savedInstanceState)
    }

    abstract fun onBaseCreate(savedInstanceState: Bundle?)

}