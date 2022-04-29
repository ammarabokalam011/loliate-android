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
import retrofit2.http.Query

interface ApiInterfaces {

    @POST("signin")
    fun login(@Body model: LoginRequest): Observable<BaseResponse<LoginResponse>>

    @GET("categories")
    fun getCategoriesList(/*@Body filter: ChannelFilter*/): Observable<BaseResponse<MutableList<Category>>>

    @GET("products/getByCategoryId")
    fun getProductsList(@Query("categoryID") categoryID: Int): Observable<BaseResponse<MutableList<Product>>>

    @GET("products/getByProductId")
    fun getProduct(@Query("productID") productId: Int): Observable<BaseResponse<Product>>

    @POST("users")
    fun getUser(): Observable<BaseResponse<User>>

    @GET("products/getByProductsIds")
    fun getProductsbyIDs(@Query("productsIDs") productId:  MutableList<Int> ): Observable<BaseResponse<MutableList<Product>>>
    //=1, 2 , 3
}
