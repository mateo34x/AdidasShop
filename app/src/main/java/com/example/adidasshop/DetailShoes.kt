package com.example.adidasshop

import android.content.Intent
import android.os.Bundle
import android.widget.HorizontalScrollView
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bumptech.glide.Glide

class DetailShoes : AppCompatActivity() {

    private lateinit var Photo2 : ImageView
    private lateinit var horizontalScrollView : HorizontalScrollView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_shoes)
        horizontalScrollView = findViewById(R.id.horizontalScrollView)
        horizontalScrollView.isHorizontalScrollBarEnabled = false

        Photo2 = findViewById(R.id.photo2)

        val getEncode = intent.getStringExtra("photo2")
        getEncode.let {
            Glide.with(this@DetailShoes)
                .asBitmap()
                .load(it)
                .into(Photo2)
        }
    }
}