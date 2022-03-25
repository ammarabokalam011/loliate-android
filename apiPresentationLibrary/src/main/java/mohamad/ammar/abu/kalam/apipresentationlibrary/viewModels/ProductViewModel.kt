package mohamad.ammar.abu.kalam.apipresentationlibrary.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Product

class ProductViewModel : ViewModel() {
    val productList: MutableLiveData<MutableList<Product>> = MutableLiveData()
}