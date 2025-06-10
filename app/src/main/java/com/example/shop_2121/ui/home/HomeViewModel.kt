package com.example.shop_2121.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shop_2121.models.ProductItem
import com.example.shop_2121.repositores.ProductsRepository

class homeViewModel : ViewModel() {

    var respository:ProductsRepository = ProductsRepository()

    var responceLiveData: LiveData<ArrayList<ProductItem>?> = MutableLiveData<ArrayList<ProductItem>?>()

    fun getResponseLiveData(): LiveData<ArrayList<ProductItem>?>{
        responceLiveData = respository.getProductList()
        return responceLiveData
    }


}