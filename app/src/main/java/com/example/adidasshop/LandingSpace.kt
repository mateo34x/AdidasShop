package com.example.adidasshop

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.postDelayed
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.adidasshop.R
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class LandingSpace : AppCompatActivity() {
    private lateinit var bottom: ImageButton;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_space)

        ShoesList.shoesList = getShoesList()




        bottom = findViewById(R.id.get);
        bottom.setOnClickListener {


            if (ShoesList.shoesList.size > 0) {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"Cargando", Toast.LENGTH_LONG).show()



                    GetDataApi().date(this@LandingSpace)



            }


        }
    }



    private fun getShoesList(): MutableList<GroceryItem> {
        val sharedPreferences = getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)

        val surveylistlocal = sharedPreferences.getString("shoeslocal",null)

        val gson = Gson()
        val type = object : TypeToken<MutableList<GroceryItem>>() {}.type
        return gson.fromJson(surveylistlocal, type) ?: mutableListOf()
    }
}