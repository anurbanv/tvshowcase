package com.anurbanv.tvshowcase.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.anurbanv.tvshowcase.R
import com.anurbanv.tvshowcase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        navController = Navigation.findNavController(this, R.id.fragmentContainerView)

        binding.toolbar.setupWithNavController(navController)
    }
}