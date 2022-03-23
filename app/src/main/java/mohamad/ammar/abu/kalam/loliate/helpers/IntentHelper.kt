package mohamad.ammar.abu.kalam.loliate.helpers

import android.content.Context
import android.content.Intent
import com.google.gson.Gson
import mohamad.ammar.abu.kalam.loliate.activities.LoginActivity

class IntentHelper {

    companion object {
        fun startLoginActivity(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
        }

//        fun startMainActivity(context: Context) {
//            val intent = Intent(context, MainActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or
//                    Intent.FLAG_ACTIVITY_CLEAR_TASK
//            context.startActivity(intent)
//        }
//
//        fun startMovieDetailsActivity(context: Context, poJo: MovieBase) {
//            val intent = Intent(context, MovieDetailsActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            intent.putExtra(
//                MovieDetailsActivity.MovieDetailsActivity_Tag,
//                Gson().toJson(poJo).toString()
//            )
//            context.startActivity(intent)
//        }
//
//        fun startMoviesActivity(context: Context, poJo: MovieGroupBase) {
//            val intent = Intent(context, MoviesActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            val filter = MovieFilter()
//            filter.movGrpId = poJo.movGrpId
//            intent.putExtra(MoviesActivity.MoviesActivity_Tag, Gson().toJson(filter).toString())
//            context.startActivity(intent)
//        }
//
//        fun startFavouriteEditActivity(context: Context, favoriteGroupModel: FavoriteGroupModel) {
//            val intent = Intent(context, FavouriteEditActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            intent.putExtra(
//                FavouriteEditActivity.favouriteEditActivity_Tag,
//                Gson().toJson(favoriteGroupModel).toString()
//            )
//            context.startActivity(intent)
//        }
//
//        fun startChannelLockActivity(context: Context) {
//            val intent = Intent(context, ChannelLockActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            context.startActivity(intent)
//        }
//
//        fun startChannelDetailsActivity(context: Context, channelBase: ChannelBase) {
//            val intent = Intent(context, ChannelDetailsActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            intent.putExtra(
//                ChannelDetailsActivity.ChannelDetailsActivity_Tag,
//                Gson().toJson(channelBase).toString()
//            )
//            context.startActivity(intent)
//        }
//
//        fun startChannelsListActivity(context: Context, channelFilter: ChannelFilter) {
//            val intent = Intent(context, ChannelsActivity::class.java)
//            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//            intent.putExtra(
//                ChannelsActivity.ChannelsActivity_Tag,
//                Gson().toJson(channelFilter).toString()
//            )
//            context.startActivity(intent)
//        }

    }

}