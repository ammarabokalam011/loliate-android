package mohamad.ammar.abu.kalam.apipresentationlibrary.repositories

import android.R.id.edit
import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences


abstract class BasePrefRepository(context: Context) {
    var Repository_Tag = "Repository_Tag"

    var preferences: SharedPreferences
    var editor: SharedPreferences.Editor

    init {
        preferences = context.getSharedPreferences(Repository_Tag, Context.MODE_PRIVATE)
        editor = preferences.edit()
    }

}