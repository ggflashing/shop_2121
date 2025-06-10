package com.example.shop_2121.repositores

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shop_2121.models.ProductItem
import com.example.shop_2121.remote_data.LRetrofit
import com.example.shop_2121.remote_data.ServisApi

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsRepository {  // хранилище

    companion object{
        private lateinit var servisApi: ServisApi

        init {
            try {
                servisApi = LRetrofit.retrofitService
            }catch (e:Exception){
                Log.e("TAG", "ERROR"+"Retrofit api_service reating is Faiulure!" + e.localizedMessage)
            }
        }
    }


    val data: MutableLiveData<ArrayList<ProductItem>?> = MutableLiveData<ArrayList<ProductItem>?>()

    fun getProductList(): LiveData<ArrayList<ProductItem>?>{

        val apiCall: Call<ArrayList<ProductItem>> = servisApi.getStoreProducts()

        apiCall.enqueue(object : Callback<ArrayList<ProductItem>?> {
            override fun onResponse(call:Call<ArrayList<ProductItem>?>,
                response: Response<ArrayList<ProductItem>?>) {
                try {
                    data.postValue(response.body())
                }catch (e:Exception){
                    Log.e("TAG","ERROR!! Failure set data"+e.localizedMessage)
                }

            }

            override fun onFailure(p0: Call<ArrayList<ProductItem>?>, throw_exeption: Throwable) {
                Log.e("TAG","NO DATA FROM SERVER"+ throw_exeption.localizedMessage)
                data.postValue(null)

            }

        })
        return data
    }


}


