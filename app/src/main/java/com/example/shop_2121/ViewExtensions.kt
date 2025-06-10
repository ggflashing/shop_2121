package com.example.shop_2121

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import com.bumptech.glide.Glide

fun View.visibility(isVisible: Boolean){

    if (isVisible== true){
        this.visibility = View.VISIBLE
    }else{
        this.visibility = View.GONE
    }

}

fun ImageView.loadImage(uri: String){
    Glide
        .with(this)
        .load(uri)
        .centerCrop()
        .placeholder(R.drawable.baseline_heart_broken_24)
        .error(R.drawable.ic_launcher_background)
        .into(this)
}

fun showToast(context: Context,msg:String){
    Toast.makeText(context,msg,Toast.LENGTH_LONG).show()
}