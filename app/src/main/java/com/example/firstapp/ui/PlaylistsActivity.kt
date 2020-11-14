package com.example.firstapp.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import com.example.firstapp.R
import com.example.firstapp.ui.adapter.MainAdapter
import kotlinx.android.synthetic.main.activity_main.*

class PlaylistsActivity : AppCompatActivity() {

    private lateinit var adapter: MainAdapter
    private lateinit var viewModel: PlaylistViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(PlaylistViewModel::class.java)
        setupAdapter()

        fetchPlaylists()
    }

    private fun setupAdapter() {
        adapter = MainAdapter()
        recycler_view.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        recycler_view.adapter = adapter
        val snap = LinearSnapHelper()
        snap.attachToRecyclerView(recycler_view)
//        adapter.addItems(urls)
    }

    private fun fetchPlaylists() {
        viewModel.fetchPlaylists().observe(this, Observer {
            Log.v("RESULT_FETCH_PLAYLISTS", it.toString())
        })
    }

}