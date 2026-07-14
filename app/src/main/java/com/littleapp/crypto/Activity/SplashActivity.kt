package com.littleapp.crypto.Activity

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.littleapp.crypto.databinding.ActivitySplashBinding
import com.littleapp.crypto.utils.THEME
import com.littleapp.crypto.utils.launchActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    private val timePerSecond = 2
    private val timeFinal = TIME_PER_MILLIS * timePerSecond

    override fun onCreate(savedInstanceState: Bundle?) {
        THEME.setThemeOfApp(this)
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({ launch() }, timeFinal.toLong())
    }

    private fun launch() {
        launchActivity<MainActivity>()
        finish()
    }

    companion object {
        private const val TIME_PER_MILLIS = 1000
    }
}