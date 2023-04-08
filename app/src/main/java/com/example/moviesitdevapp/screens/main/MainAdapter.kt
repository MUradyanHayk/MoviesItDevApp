package com.example.moviesitdevapp.screens.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.moviesitdevapp.databinding.ItemLayoutBinding

class MainAdapter : RecyclerView.Adapter<MainAdapter.MainAdapterViewHolder>() {


    class MainAdapterViewHolder(binding: ItemLayoutBinding) : ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapterViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return 0
    }

    override fun onBindViewHolder(holder: MainAdapterViewHolder, position: Int) {
    }
}