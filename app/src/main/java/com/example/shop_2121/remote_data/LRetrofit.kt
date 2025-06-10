package com.example.shop_2121.remote_data

import android.provider.SyncStateContract.Constants
import com.example.shop_2121.contant.ConstanApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object LRetrofit {


    val logging = HttpLoggingInterceptor()
    val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(30,TimeUnit.SECONDS)
        .writeTimeout(30,TimeUnit.SECONDS)
        .addInterceptor(logging)
        .readTimeout(30,TimeUnit.SECONDS)
        .build()


    private val builder: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .baseUrl(ConstanApi.BASE_URL)
        .build()

    val retrofitService: ServisApi by lazy {
        builder.create(ServisApi::class.java)
    }



}