package mohamad.ammar.abu.kalam.apipresentationlibrary.di.dialogs

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager

abstract class BaseDialog : DialogFragment() {

    abstract var BaseDialog_Tag: String

    companion object {

        public fun closeDialog(supportFragmentManager: FragmentManager, dialogTag: String) {
            try {
                val dialog: BaseDialog? = supportFragmentManager
                        .findFragmentByTag(dialogTag) as BaseDialog?
                val res = dialog?.dialog?.isShowing
                if ((res != null) && (res != false)) {
                    dialog.dismiss()
                }
            } catch (ex: Exception) {
            }
        }

    }

    fun showDialog(supportFragmentManager: FragmentManager, dialogTag: String) {
        closeDialog(supportFragmentManager, dialogTag)
        show(supportFragmentManager, dialogTag)
    }



    override fun show(manager: FragmentManager, tag: String?) {
        try {
            val ft = manager.beginTransaction()
            ft.add(this, tag)
            ft.commitAllowingStateLoss()
        } catch (e: IllegalStateException) {

        }
    }
//    override fun (manager: FragmentManager?, tag: String?) {
//
//    }

}