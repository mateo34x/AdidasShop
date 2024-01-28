package com.example.adidasshop

import android.app.Activity
import android.content.ClipData.Item
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.Response
import java.io.IOException

class GetDataApi {
    fun date(activity: Activity){

        val client = OkHttpClient().newBuilder().build()
        val gson = Gson()
        val token = "eyJBdXRob3JpemF0aW9uIjoiQmVhcmVyIiwiYWxnIjoiSFMyNTYifQ.eyJzdWIiOiJtYXRlbzE1cmdAZ21haWwuY29tIiwicm9sZSI6IkFETUlOIiwiZXhwIjoxNzM4MzQ4MTQwfQ.MZBNBXVj1kugHTLkfVTkez-8Hz1jLUvwDvRJ0O4KqB0"

        val request =
            Request.Builder().url("https://apishopfake-production.up.railway.app/view/findAll")
                .header("Authorization", "Bearer $token")
                .get().build();

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {

                var itemsProcessed = 0
                if (response.isSuccessful) {
                    val responseData = response.body?.string()
                    val items = gson.fromJson(responseData, Array<GroceryItem>::class.java).toList()

                    // Mostrar datos en el Log utilizando el método toString() de GroceryItem
                    items.forEach { item ->
                        val id = item.id
                        val name = item.name
                        val description = item.description
                        val prices = item.price
                        val quantity = item.quantity
                        val category = item.category
                        val nombre = item.nombre
                        val mimeType = item.mimeType
                        val fotoBase1 = item.fotoBase1
                        val fotoBase2 = item.fotoBase2

                        ShoesList.shoesList.add(

                            GroceryItem(id,name,description,prices,quantity,category, nombre, mimeType, fotoBase1,fotoBase2)

                        )
                        itemsProcessed++
                    }

                    if (itemsProcessed==items.size){
                        val sharedPreferences =
                            activity.getSharedPreferences("MyAppPrefs", Context.MODE_PRIVATE)
                        val editor = sharedPreferences.edit()

                        val gson = Gson()
                        val json = gson.toJson(ShoesList.shoesList)

                        editor.putString("shoeslocal", json)
                        editor.apply()

                        Log.e("valor",""+ShoesList.shoesList.toString())

                        val intent = Intent(activity, MainActivity::class.java)
                        activity.startActivity(intent)
                        activity.finish()

                    }

                }else if (response.code == 401){
                    Toast.makeText(activity,"Token invalid,\ngenerate new token", Toast.LENGTH_LONG).show()
                }
            }

        })


    }
}