package com.littleapp.crypto.Activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.littleapp.crypto.R
import com.littleapp.crypto.Unit.THEME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val activityContext: Context by lazy { this }

    override fun onCreate(savedInstanceState: Bundle?) {
        THEME.setThemeOfApp(activityContext)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}