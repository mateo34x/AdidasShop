package com.example.adidasshop

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adidasshop.R

class LandingSpace : AppCompatActivity() {
    private lateinit var bottom: ImageButton;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_space)

        bottom = findViewById(R.id.get);
        bottom.setOnClickListener {
            //GetDataApi().date(this@LandingSpace)
            val intent = Intent(this@LandingSpace, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}