package com.example.moviesitdevapp.screens.main

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.moviesitdevapp.R
import com.example.moviesitdevapp.databinding.ItemLayoutBinding
import com.example.moviesitdevapp.model.MovieItemModel
import com.example.moviesitdevapp.utils.BASE_URL
import java.lang.ref.WeakReference

interface MainAdapterDelegate{
    fun clickMovie(model: MovieItemModel)
}
class MainAdapter(val context: Context) : RecyclerView.Adapter<MainAdapter.MainAdapterViewHolder>() {

    private var moviesList = emptyList<MovieItemModel>()

    var delegate:WeakReference<MainAdapterDelegate>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapterViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainAdapterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MainAdapterViewHolder, position: Int) {
        holder.binding.itemTitle.text = moviesList[position].title
        holder.binding.itemDete.text = moviesList[position].release_date

        holder.binding.root.setOnClickListener {
            delegate?.get()?.clickMovie(moviesList[position])
        }

        Glide.with(context)
            .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${moviesList[position].poster_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.binding.itemImg)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list: List<MovieItemModel>) {
        moviesList = list
        notifyDataSetChanged()
    }

    class MainAdapterViewHolder(val binding: ItemLayoutBinding) : ViewHolder(binding.root)

}