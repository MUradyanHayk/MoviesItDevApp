package com.example.moviesitdevapp.screens.main

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesitdevapp.MainActivity
import com.example.moviesitdevapp.R
import com.example.moviesitdevapp.databinding.FragmentMainBinding
import com.example.moviesitdevapp.model.MovieItemModel
import com.example.moviesitdevapp.utils.MAIN
import java.lang.ref.WeakReference

class MainFragment : Fragment(), AdapterDelegate {

//    private var _binding:FragmentMainBinding? = null
//    private val binding:FragmentMainBinding
//        get() = _binding!!

    private lateinit var binding: FragmentMainBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MainAdapter
    private val viewModel: MainFragmentViewModel by lazy {
        ViewModelProvider(this)[MainFragmentViewModel::class.java]
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentMainBinding.inflate(layoutInflater, container, false)
        setHasOptionsMenu(true)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
        adapter = MainAdapter(requireContext())
        adapter.delegate = WeakReference(this)
        viewModel.getMoviesFromServer()
        viewModel.initDatabase()
        recyclerView = binding.rvMain
        recyclerView.adapter = adapter
        viewModel.movies.observe(viewLifecycleOwner) { movies ->
            movies.body()?.let {
                adapter.setList(it.movieItemModels)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.item_favorite -> {
                (activity as MainActivity?)?.navController?.navigate(R.id.action_mainFragment_to_favoriteFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun clickMovie(model: MovieItemModel) {
        try {
            val bundle = Bundle()
            bundle.putSerializable("model", model)
            MAIN.navController.navigate(R.id.action_mainFragment_to_detailFragment, bundle)
        } catch (e: Exception) {
            Log.e(TAG, e.message.toString())
        }
    }

    companion object {
        const val TAG = "MainFragment"
    }
}