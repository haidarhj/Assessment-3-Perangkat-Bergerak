package org.d3if0113.noted.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import org.d3if0113.noted.model.Mobil
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private  const val BASE_URL = "https://raw.githubusercontent.com/haidarhj/json-Assesment3/main/"

private  val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface mobilApiService {

    @GET("Mobil.json")
    suspend fun getMobil(): List<Mobil>
}

object MobilApi {
    val service: mobilApiService by lazy {
        retrofit.create(mobilApiService::class.java)
    }

    fun getMobilUrl(gambar: String): String {
        return  "$BASE_URL$gambar.jpg"
    }
}

enum class  ApiStatus { LOADING, SUCCESS, FAILED}