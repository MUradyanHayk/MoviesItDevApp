package com.example.moviesitdevapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.moviesitdevapp.databinding.ActivityMainBinding
import com.example.moviesitdevapp.utils.MAIN

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        MAIN = this

//        navController = Navigation.findNavController(this, R.id.nav_graph)
    }
}