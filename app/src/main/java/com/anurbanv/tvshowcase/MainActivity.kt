package com.anurbanv.tvshowcase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anurbanv.tvshowcase.util.JsonUtil
import com.google.gson.Gson
import com.google.gson.JsonObject

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val gson = Gson()

        val jsonString = JsonUtil.loadJsonFromAssets(this, "hbo-silicon-valley.json")

        val fromJson = gson.fromJson(jsonString, JsonObject::class.java)

        println(fromJson.toString())
    }
}