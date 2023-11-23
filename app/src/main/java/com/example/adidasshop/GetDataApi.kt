package com.example.adidasshop

import android.content.ClipData.Item
import android.content.Context
import android.util.Log
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
    fun date(context: Context) {

        val client = OkHttpClient().newBuilder().build()
        val gson = Gson()

        val request =
            Request.Builder().url("https://apishopfake-production.up.railway.app/view/findAll")
                .get().build();

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                TODO("Not yet implemented")
            }

            override fun onResponse(call: Call, response: Response) {

                if (response.isSuccessful) {
                    val responseData = response.body?.string()
                    val items = gson.fromJson(responseData, Array<GroceryItem>::class.java).toList()

                    // Mostrar datos en el Log utilizando el método toString() de GroceryItem
                    items.forEach { item ->
                        Log.e("Mateo", item.toString())
                        Log.e("valor",""+item.fotoBase64.length+"\n")
                    }
                }
            }

        })


    }
}