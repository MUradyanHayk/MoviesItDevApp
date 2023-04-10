package com.example.moviesitdevapp.screens.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.moviesitdevapp.R
import com.example.moviesitdevapp.databinding.FragmentDetailBinding
import com.example.moviesitdevapp.model.MovieItemModel
import com.example.moviesitdevapp.screens.main.MainAdapter
import com.example.moviesitdevapp.utils.MAIN
import java.lang.ref.WeakReference

class DetailFragment : Fragment() {
    private lateinit var binding: FragmentDetailBinding
    private var currentMovie: MovieItemModel? = null
    private var isFavorite = false
    private val viewModel: DetailFragmentViewModel by lazy {
        ViewModelProvider(this)[DetailFragmentViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentDetailBinding.inflate(layoutInflater, container, false)
        currentMovie = arguments?.getSerializable("model") as MovieItemModel?
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
        val _currentMovie = currentMovie ?: return
        binding.tvTitle.text = _currentMovie.title
        binding.tvDescription.text = _currentMovie.overview
        binding.tvDate.text = _currentMovie.release_date

        binding.imgDetailFavorite.setOnClickListener {
            if (!isFavorite) {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_favorite)
            } else {
                binding.imgDetailFavorite.setImageResource(R.drawable.ic_favorite_border)
            }

            isFavorite = !isFavorite
        }

        Glide.with(MAIN)
            .load("https://www.themoviedb.org/t/p/w600_and_h900_bestv2${_currentMovie.poster_path}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.imgDetail)
    }
}