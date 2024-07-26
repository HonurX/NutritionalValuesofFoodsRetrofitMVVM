package com.onurgunes.caloriehandbookretrofitmvvm.SharedPreferences

import android.content.Context
import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.onurgunes.caloriehandbookretrofitmvvm.R

fun ImageView.gorselIndir (url : String? , placeholder : CircularProgressDrawable ) {
 val options = RequestOptions().placeholder(placeholder).error(R.mipmap.ic_launcher_round)
     Glide.with(context).setDefaultRequestOptions(options).load(url).into(this)

}

fun placeHolderMake (context: Context) :CircularProgressDrawable {
    return  CircularProgressDrawable(context).apply {
        strokeWidth = 8f
        centerRadius = 40f
            start()

    }

}