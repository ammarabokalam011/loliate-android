package mohamad.ammar.abu.kalam.apipresentationlibrary.apiService

import android.content.Context
import mohamad.ammar.abu.kalam.apipresentationlibrary.repositories.LoginRepository
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiServer(val context: Context) {
    val apiInterfaces: ApiInterfaces

    init {

        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BASIC
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
        val login = LoginRepository(context).getLoginResponse()
        if (login != null) {
            client.addInterceptor {
                it.proceed(
                    it.request().newBuilder().addHeader(
                        "Authorization",
                        "Bearer " + login.authenticationToken
                    ).build()
                )
            }
        }
        val retrofit = Retrofit.Builder()
            .baseUrl(ApiInfo.baseUrlApi)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .client(client.build())
            .build()

        apiInterfaces = retrofit.create(
            ApiInterfaces::
            class.java
        )
    }

}