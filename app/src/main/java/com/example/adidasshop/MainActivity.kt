package com.example.adidasshop

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            recyclerView = findViewById(R.id.recyclerShoes)
            val adapter = ShoesAdapter(ShoesList.shoesList)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(this)



    }

    override fun onStart() {
        super.onStart()

    }
}