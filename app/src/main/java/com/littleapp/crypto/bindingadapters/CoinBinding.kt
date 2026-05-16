package com.littleapp.crypto.bindingadapters

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.littleapp.crypto.Unit.DATA.IMAGE_CRYPTO
import com.littleapp.crypto.utils.loadImage

class CoinBinding {

    companion object {

        @BindingAdapter("load_image")
        @JvmStatic
        fun loadImage(imageView: ImageView, coinImage: String) {
            val imageUrl = "$IMAGE_CRYPTO$coinImage.png"
            imageView.loadImage(imageUrl)
        }
    }
}