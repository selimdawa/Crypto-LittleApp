package com.littleapp.crypto.ui.home

import android.widget.ImageView
import android.widget.TextView
import com.littleapp.crypto.model.home.Data

interface ItemClickListener {
    fun onItemClick(coin: Data, ivRowImage: ImageView, tvRowTitle: TextView, tvRowSymbol: TextView)
}