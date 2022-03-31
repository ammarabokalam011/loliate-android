package mohamad.ammar.abu.kalam.loliate.helpers

import android.content.Context
import android.content.Intent
import mohamad.ammar.abu.kalam.loliate.activities.LoginActivity
import mohamad.ammar.abu.kalam.loliate.activities.CategoryActivity
import mohamad.ammar.abu.kalam.loliate.activities.ProductDetailActivity
import mohamad.ammar.abu.kalam.loliate.activities.ProductsActivity

class IntentHelper {

    companion object {
        fun startLoginActivity(context: Context) {
            val intent = Intent(context, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK
            context.startActivity(intent)
        }

        fun startCategoryActivity(context: Context, id: Int?=null) {
            val intent = Intent(context, CategoryActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK
            if(id!=null)
                intent.putExtra("parentId",id)
            context.startActivity(intent)
        }

        fun startListProductActivity(context: Context, id: Int) {
            val intent = Intent(context, ProductsActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK
            if(id!=null)
                intent.putExtra("categoryId",id)
            context.startActivity(intent)
        }

        fun startProductDetailActivity(context: Context, id: Int) {
            val intent = Intent(context, ProductDetailActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP or
                    Intent.FLAG_ACTIVITY_CLEAR_TASK
            intent.putExtra("productId",id)
            context.startActivity(intent)
        }

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