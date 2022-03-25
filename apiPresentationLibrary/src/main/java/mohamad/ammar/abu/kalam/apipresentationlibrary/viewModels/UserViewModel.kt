package mohamad.ammar.abu.kalam.apipresentationlibrary.viewModels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.User

class UserViewModel : ViewModel() {
    val userList: MutableLiveData<MutableList<User>> = MutableLiveData()
}