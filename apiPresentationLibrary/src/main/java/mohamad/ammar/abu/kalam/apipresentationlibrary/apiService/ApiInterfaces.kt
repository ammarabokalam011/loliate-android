package mohamad.ammar.abu.kalam.apipresentationlibrary.apiService

import mohamad.ammar.abu.kalam.apipresentationlibrary.responses.BaseResponse
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Category
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.Product
import mohamad.ammar.abu.kalam.apipresentationlibrary.entities.User
import mohamad.ammar.abu.kalam.apipresentationlibrary.request.LoginRequest
import mohamad.ammar.abu.kalam.apipresentationlibrary.responses.LoginResponse
import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterfaces {

    @POST("signin")
    fun login(@Body model: LoginRequest): Observable<BaseResponse<LoginResponse>>

    @GET("categories")
    fun getCategoriesList(/*@Body filter: ChannelFilter*/): Observable<BaseResponse<MutableList<Category>>>

    @POST("categories/{id}")
    fun getCategory(): Observable<BaseResponse<Category>>


    @POST("products/{categoryId}")
    fun getProductsList(): Observable<BaseResponse<MutableList<Product>>>

    @POST("products/{id}")
    fun getProduct(): Observable<BaseResponse<Product>>

    @POST("users")
    fun getUser(): Observable<BaseResponse<User>>

}