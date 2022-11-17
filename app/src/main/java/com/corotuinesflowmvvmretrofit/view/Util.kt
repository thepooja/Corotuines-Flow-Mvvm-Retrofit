package com.devtides.coroutinesretrofit.view

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.corotuinesflowmvvmretrofit.R

fun ImageView.loadImage(uri: String?) {
    val options = RequestOptions()
        .error(R.mipmap.ic_launcher_round)
    Glide.with(this.context)
        .setDefaultRequestOptions(options)
        .load(uri)
        .into(this)
}