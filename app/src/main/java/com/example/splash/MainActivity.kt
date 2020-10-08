package com.example.splash

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import androidx.core.app.ActivityOptionsCompat
import android.util.Pair as Apair

class MainActivity : AppCompatActivity() {

    val SPLASH_SCREEN: Long = 2000

    lateinit var topAnim: Animation
    lateinit var btmAnim: Animation
    lateinit var imageView: ImageView
    lateinit var logo: TextView
    lateinit var slogan: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)

        topAnim = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        btmAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        imageView = findViewById(R.id.imageView)
        logo = findViewById(R.id.logo)
        slogan = findViewById(R.id.slogan)

        imageView.startAnimation(topAnim)
        logo.startAnimation(btmAnim)
        slogan.startAnimation(btmAnim)

        Handler().postDelayed(Runnable {
                val intent = Intent(this, Login::class.java)
                var p1 = Apair.create<View?, String?>(imageView, "logo_image")
                var p2 = Apair.create<View?, String?>(logo, "logo_text")


                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this, *arrayOf(p1,p2)).toBundle())
                finish()

        },SPLASH_SCREEN)
    }
}

