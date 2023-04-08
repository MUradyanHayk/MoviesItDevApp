package com.example.moviesitdevapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.moviesitdevapp.utils.MAIN

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MAIN = this
    }
}