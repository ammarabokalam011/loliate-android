package mohamad.ammar.abu.kalam.apipresentationlibrary.di.ui

import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Category

class CategoryContract {

    interface Presenter : BaseContract.Presenter<View> {
        fun getCategories(id: Int?)
    }

    interface View : BaseContract.View {
        fun onRetrievingCategoriesSuccessfully(categories: MutableList<Category>) {}
        fun onRetrievingCategoriesFailed() {}

        //        fun onProfileLoadedSuccessfully(user: User) {}
        fun onRetrievingCategoriesLoadingFailed() {}
    }
}