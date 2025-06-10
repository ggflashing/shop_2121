package com.example.shop_2121.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class ProductItem(
    @SerializedName("id")
    @Expose
    val id:Int,

    @SerializedName("title")
    @Expose
    val title:String,

    @SerializedName("price")
    @Expose
    val price:Double,

    @SerializedName("description")
    @Expose
    val description:String,

    @SerializedName("image")
    @Expose
    val image:String
)
    :Serializable

