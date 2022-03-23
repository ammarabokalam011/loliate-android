package mohamad.ammar.abu.kalam.loliate.helpers

import android.text.TextUtils
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import java.util.*

class BindingHelper {

    companion object {

//        /*Channel started*/
//        @JvmStatic
//        @BindingAdapter("channelImage")
//        fun bindChannelIcon(imageView: ImageView, channelBase: ChannelBase) {
//            val context = imageView.context
//            val url = ApiInfo.baseChannelImageUrl + channelBase.chnlLogo
//            val requestOption = RequestOptions()
//                .placeholder(R.drawable.ic_dummy)
//                .error(R.drawable.ic_dummy)
//            Glide.with(context)
//                .load(url)
//                .apply(requestOption)
//                .into(imageView)
//        }
//
//        @JvmStatic
//        @BindingAdapter("channelSelection")
//        fun bindChannelSelection(compoundButton: CompoundButton, channelBase: ChannelBase) {
//            val isChecked = channelBase.getSelectedItemTrusted()
//            compoundButton.isChecked = isChecked
//        }
//
//        @JvmStatic
//        @BindingAdapter("channelText")
//        fun bindChannelText(radioButton: RadioButton, channelBase: ChannelBase) {
//            radioButton.text = channelBase.getName()
//            radioButton.isSelected = true
//        }
//
//        @JvmStatic
//        @BindingAdapter("channelNumber")
//        fun bindChannelNumberText(textView: TextView, channelBase: ChannelBase) {
//            val number = String.format(Locale.ENGLISH, "%4d", channelBase.position + 1)
//            textView.text = number
//        }
//
//        @JvmStatic
//        @BindingAdapter("channelGridText")
//        fun bindChannelGridText(radioButton: RadioButton, channelBase: ChannelBase) {
//            radioButton.text = channelBase.getName()
//            val isSelected = channelBase.getSelectedItemTrusted()
//            if (isSelected) {
//                radioButton.ellipsize = TextUtils.TruncateAt.MARQUEE
//            } else {
//                radioButton.ellipsize = null
//            }
//        }
//
//        @JvmStatic
//        @BindingAdapter("channelLocked")
//        fun bindChannelLocked(view: CompoundButton, channelBase: ChannelBase) {
//            val channelDb = AppDatabase.getInstance(App.app)
//                .channelLockDao().findByChannelDbId(chnlId = channelBase.chnlId)
//            view.isChecked = (channelDb != null)
//        }
//        /*Channel ended*/
//
//
//        /*Radio started*/
//
//        @JvmStatic
//        @BindingAdapter("radioSelected")
//        fun bindRadioSelected(compoundButton: CompoundButton, radioBase: RadioBase) {
//            val isChecked = radioBase.getSelectedItemTrusted()
//            compoundButton.isChecked = isChecked
//        }
//
//        @JvmStatic
//        @BindingAdapter("radioSelection")
//        fun bindRadioSelection(view: View, radioBase: RadioBase) {
//            val context = view.context
//            val isChecked = radioBase.getSelectedItemTrusted()
//            if (isChecked) {
//                view.background = ContextCompat.getDrawable(context, R.drawable.ic_selected_dark_bg)
//            } else {
//                view.setBackgroundColor(ContextCompat.getColor(context, R.color.transparent))
//            }
//        }
//
//        @JvmStatic
//        @BindingAdapter("radioIcon")
//        fun bindRadioIcon(imageView: ImageView, radioBase: RadioBase) {
//            try {
//                val context = imageView.context
//                val url = ApiInfo.baseRadioImageUrl + radioBase.rdoLogo
//                val requestOption = RequestOptions()
////                    .placeholder(R.drawable.ic_dummy)
//                    .error(R.drawable.ic_dummy)
//                Glide.with(context)
//                    .load(url)
//                    .apply(requestOption)
////                    .placeholder(R.drawable.ic_dummy)
//                    .into(imageView)
//            } catch (ex: Exception) {
//
//            }
//        }
//
//        @JvmStatic
//        @BindingAdapter("radioStatus")
//        fun bindRadioStatus(view: View, radioBase: RadioBase) {
//            try {
//                val imageView: ImageView = view.findViewById(R.id.radioPlayerStatus)
//                val progressWheel: ProgressWheel = view.findViewById(R.id.progressWheel)
//                val radioStatus = radioBase.getPlayerStatusWithInitialize()
//
//                when (radioStatus) {
//                    RadioPlayerStatus.LOADING.value -> {
//                        imageView.setImageDrawable(null)
//                        progressWheel.visibility = View.VISIBLE
//                    }
//                    RadioPlayerStatus.NOT_SET.value -> {
//                        imageView.setImageDrawable(null)
//                        progressWheel.visibility = View.INVISIBLE
//                    }
//                    RadioPlayerStatus.PAUSE.value -> {
//                        imageView.setImageResource(R.drawable.ic_play_arrow_white_24dp)
//                        progressWheel.visibility = View.INVISIBLE
//                    }
//                    RadioPlayerStatus.PLAY.value -> {
//                        imageView.setImageResource(R.drawable.ic_pause_white_24dp)
//                        progressWheel.visibility = View.INVISIBLE
//                    }
//                    RadioPlayerStatus.ERROR.value -> {
//                        imageView.setImageResource(R.drawable.ic_error_white_24dp)
//                        progressWheel.visibility = View.INVISIBLE
//                    }
//                }
//
//            } catch (ex: Exception) {
//
//            }
//        }
//
//        /*Radio ended*/
//
//        /*Package started*/
//
//        @JvmStatic
//        @BindingAdapter("packageText")
//        fun bindPackageText(view: RadioButton, packageBase: PackageBase) {
//            view.text = packageBase.chnlPkgLocalName
//        }
//
//        @JvmStatic
//        @BindingAdapter("packageSelection")
//        fun bindPackageSelection(view: RadioButton, packageBase: PackageBase) {
//            when (packageBase.chnlPkgStatus) {
//                StatusEnum.Active.status ->
//                    view.setBackgroundResource(R.drawable.ic_channel_item)
//                StatusEnum.Active.status ->
//                    view.setBackgroundResource(R.drawable.ic_channel_item_bg)
//                else ->
//                    view.setBackgroundResource(R.color.white)
//
//            }
//        }
//
//        /*Package ended*/
//
//        /* Favourite started*/
//
//        @JvmStatic
//        @BindingAdapter("favoriteName")
//        fun bindFavoriteGroupName(view: TextView, favoriteGroupModel: FavoriteGroupModel) {
//            view.setText(favoriteGroupModel.name)
//        }
//
//        @JvmStatic
//        @BindingAdapter(value = ["favoriteGroupModel", "channelBase"])
//        fun bindChannelFavourite(
//            view: CompoundButton,
//            favoriteGroupModel: FavoriteGroupModel,
//            channelBase: ChannelBase
//        ) {
//            try {
//                val context = view.context
//                val count = AppDatabase.getInstance(context).channelInFavDao()
//                    .checkChannelInFavoriteGroup(
//                        favoriteGroupModel.getGuidWithDefault(),
//                        channelBase.chnlId
//                    )
//                view.isChecked = (count != null) && (count > 0)
//            } catch (ex: Exception) {
//
//            }
//        }
//        /* Favourite ended*/
//
    }

}