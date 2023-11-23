package com.example.adidasshop

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SplashScreen : AppCompatActivity() {
    private lateinit var icon : VideoView
    private lateinit var uri : Uri
    private lateinit var mediaController: MediaController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        icon = findViewById(R.id.icon);
        val url = "android.resource://" + getPackageName()+ "/" + R.raw.logoanimated2
        uri = Uri.parse(url)

        icon.setVideoURI(uri)

        mediaController = MediaController(this@SplashScreen)
        mediaController.setAnchorView(icon)
        icon.setMediaController(mediaController)

        icon.start()

        val handler = Handler()
        val delayMillis = 4000

        handler.postDelayed({
            val intent = Intent(this@SplashScreen, LandingSpace::class.java)
            startActivity(intent)
            finish()

        }, delayMillis.toLong())

    }
}