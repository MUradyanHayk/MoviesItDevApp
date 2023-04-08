package com.example.moviesitdevapp.screens.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesitdevapp.R
import com.example.moviesitdevapp.databinding.FragmentMainBinding

class MainFragment : Fragment() {

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialization()
    }

    private fun initialization() {
        adapter = MainAdapter()
        recyclerView = binding.rvMain
        recyclerView.adapter = adapter
    }
}