package com.example.rpsgamechapter5.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.rpsgamechapter5.R
import com.example.rpsgamechapter5.ui.landing.LandingPageActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val imageSplashScreen1 = findViewById<ImageView>(R.id.ivImageSplash1)
        Glide.with(this)
            .load("https://raw.githubusercontent.com/fikridivas/asset-code-challenge-chapter-5/master/PNG/splash_screen1.png") // url website
            .override(500, 500) // resize gambar
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageSplashScreen1); // set image dari website

        val imageSplashScreen2 = findViewById<ImageView>(R.id.ivImageSplash2)
        Glide.with(this)
            .load("https://raw.githubusercontent.com/fikridivas/asset-code-challenge-chapter-5/master/PNG/splash_screen2.png") // url website
            .override(500, 500) // resize gambar
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(imageSplashScreen2); // set image dari website

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, LandingPageActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}