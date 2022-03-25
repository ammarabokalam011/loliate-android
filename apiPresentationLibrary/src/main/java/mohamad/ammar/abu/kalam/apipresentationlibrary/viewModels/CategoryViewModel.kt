package mohamad.ammar.abu.kalam.apipresentationlibrary.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Category

class CategoryViewModel : ViewModel() {
    val categoryList: MutableLiveData<MutableList<Category>> = MutableLiveData()
}