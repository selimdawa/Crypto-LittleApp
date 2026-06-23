package com.littleapp.crypto.Activity

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.littleapp.crypto.databinding.ActivityMainBinding
import com.littleapp.crypto.Unit.THEME
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val activityContext: Context by lazy { this }

    override fun onCreate(savedInstanceState: Bundle?) {
        THEME.setThemeOfApp(activityContext)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}