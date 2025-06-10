package com.example.shop_2121.ui.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.shop_2121.R
import com.example.shop_2121.databinding.ItemShopBinding

import com.example.shop_2121.loadImage
import com.example.shop_2121.models.ProductItem
import com.example.shop_2121.visibility

class ShooseAdapter(var context:Context,var list:ArrayList<ProductItem>?)
    : RecyclerView.Adapter<ShooseAdapter.ViewHolder>() {

    private lateinit var binidng:ItemShopBinding

    var productT : ProductItem? = null



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShooseAdapter.ViewHolder {
        binidng = ItemShopBinding
            .inflate(LayoutInflater.from(context), parent,false)
        return ViewHolder(binidng)
    }

    override fun onBindViewHolder(holder: ShooseAdapter.ViewHolder, position: Int) {
        list?.get(position)?.let {
            holder.onBind(it)
        }
    }

    override fun getItemCount(): Int {
        return list!!.size
    }



    inner class ViewHolder(binidng:ItemShopBinding): RecyclerView.ViewHolder(binidng.root) {
        fun onBind(productItem: ProductItem) {
            binidng.apply {
                cardTitleProduct.text = productItem.title
                cardPriceProduct.text = productItem.price.toString()
                cardDesc.text = productItem.description
            }

            binidng.imageCardShop.loadImage(productItem.image)
//            if (productItem.image.size == 3){
//                binidng.apply {// оптимизация apply
//                    imageCardShop.loadImage(productItem.image[0])
//                    cardImage2Product.loadImage(productItem.image[1])
//                    cardImage3Product.loadImage(productItem.image[2])
//
//                }
//                }else{
//                binidng.apply {
//                    imageCardShop.loadImage(productItem.image[0])
//                    cardImage2Product.visibility(false)
//                    cardImage3Product.visibility(false)
//
//                }
//
//            }
         binidng.buttonHearts.setOnClickListener{v: View? ->
             productT = productItem
             var bundle = Bundle();// оптимизация
             bundle.putSerializable("key", productT)// оптимизация
             itemView.findNavController().navigate(R.id.navigation_notifications,bundle)

         }
        }
    }

}