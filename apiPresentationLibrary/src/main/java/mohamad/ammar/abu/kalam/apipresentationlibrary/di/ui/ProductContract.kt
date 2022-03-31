package mohamad.ammar.abu.kalam.apipresentationlibrary.di.ui

import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Category
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Product

class ProductContract {

    interface Presenter : BaseContract.Presenter<View> {
        fun getProducts(categoryId: Int)
        fun getProduct(productId: Int)
    }

    interface View : BaseContract.View {
        fun onRetrievingProductsSuccessfully(products: MutableList<Product>) {}
        fun onRetrievingProductsFailed() {}
        fun onRetrievingProductsLoadingFailed() {}
        fun onRetrievingProductSuccessfully(product: Product) {}
        fun onRetrievingProductFailed() {}
        fun onRetrievingProductLoadingFailed() {}
    }
}