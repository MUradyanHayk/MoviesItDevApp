package com.example.moviesitdevapp.screens.favorite

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesitdevapp.R
import com.example.moviesitdevapp.databinding.FragmentFavoriteBinding
import com.example.moviesitdevapp.databinding.FragmentMainBinding
import com.example.moviesitdevapp.model.MovieItemModel
import com.example.moviesitdevapp.screens.main.AdapterDelegate
import com.example.moviesitdevapp.screens.main.MainAdapter
import com.example.moviesitdevapp.screens.main.MainFragment
import com.example.moviesitdevapp.screens.main.MainFragmentViewModel
import com.example.moviesitdevapp.utils.MAIN
import java.lang.ref.WeakReference

class FavoriteFragment : Fragment(), AdapterDelegate {

    private lateinit var binding: FragmentFavoriteBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainAdapter
    private val viewModel: FavoriteFragmentViewModel by lazy {
        ViewModelProvider(this)[FavoriteFragmentViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
        adapter = MainAdapter(requireContext())
        adapter.delegate = WeakReference(this)
        recyclerView = binding.rvFavorite
        recyclerView.adapter = adapter

        viewModel.getAllMoviesFromDB().observe(viewLifecycleOwner) { list ->
            adapter.setList(list.asReversed())
        }
    }

    override fun clickMovie(model: MovieItemModel) {
        try {
            val bundle = Bundle()
            bundle.putSerializable("model", model)
            MAIN.navController.navigate(R.id.action_favoriteFragment_to_detailFragment, bundle)
        } catch (e: Exception) {
            Log.e(MainFragment.TAG, e.message.toString())
        }
    }
}