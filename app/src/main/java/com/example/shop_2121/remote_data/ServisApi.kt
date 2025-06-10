package com.example.shop_2121.remote_data


import com.example.shop_2121.models.ProductItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.PUT

interface ServisApi {


    @GET("products")
    fun getStoreProducts(): Call<ArrayList<ProductItem>>


//    @GET("/api/v1/products")
//    fun getAllProductList(): Call<ArrayList<ProductItem>>
//
//
//
//    @PUT("/api/v1/products/{id}")
//    fun putModel(id:Int,product: ProductItem):Call<ProductItem>

}