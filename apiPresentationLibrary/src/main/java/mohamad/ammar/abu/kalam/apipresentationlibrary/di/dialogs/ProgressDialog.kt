package mohamad.ammar.abu.kalam.apipresentationlibrary.di.dialogs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import mohamad.ammar.abu.kalam.apipresentationlibrary.R

class ProgressDialog : BaseDialog() {

    companion object {
        const val ProgressDialog_Tag = "ProgressDialog"

        fun newInstance(): ProgressDialog {
            val f = ProgressDialog()
            // Supply num input as an argument.
            f.isCancelable = false
            val args = Bundle()
            f.arguments = args
            return f
        }

        fun closeDialog(supportFragmentManager: FragmentManager) {
            try {
                val fragment =
                    supportFragmentManager.findFragmentByTag(ProgressDialog_Tag)
                if (fragment != null) {
                    val channelDialog = fragment as ProgressDialog
                    if (channelDialog.dialog != null)
                        channelDialog.dismiss()
                }
            } catch (ex: Exception) {
            }

        }

    }

    override var BaseDialog_Tag: String
        get() = ProgressDialog_Tag
        set(value) {}

    fun showDialog(supportFragmentManager: FragmentManager) {
        closeDialog(supportFragmentManager)
        this.show(supportFragmentManager, ProgressDialog_Tag)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.progress_dialog_layout, container, false)
    }


}
