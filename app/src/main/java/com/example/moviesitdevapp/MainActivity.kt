package com.example.moviesitdevapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
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

// //       navController = Navigation.findNavController(this, R.id.fragmentContainerView)
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment?
        navController = navHostFragment!!.navController

//        navController = findNavController(R.id.fragmentContainerView)
    }
}