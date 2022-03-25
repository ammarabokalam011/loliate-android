package mohamad.ammar.abu.kalam.apipresentationlibrary.responses

class BaseResponse<T> {

    var success: Boolean = true
//    var message: Message = Message()
    var message: String = ""

    var data: T? = null

    var currentPage: Int = 0

    var totalPages: Int = 0
}